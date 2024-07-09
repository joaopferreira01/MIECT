/* JAM, dez-2020
 * Ficheiros de texto
 * Lista pasta de trabalho, testa ficheiros, copia ficheiro de entrada para ficheiro de saida usando um array
 * 
 * Com a classe File escreve sempre de novo por cima do ficheiro existente, destruindo-o!
 * Com a classe FileWriter permite acrescentar (append) texto no fim do ficheiro
 */
import java.util.Scanner;
import java.io.*;		//necessárias para usar ficheiros

public class Ficheiros2 {
    public static void main(String[] args) throws IOException { //throws necessário para usar ficheiros
    
        Scanner kb = new Scanner(System.in);

        listaDir("."); // . diretorio atual

        System.out.print("Ficheiro de entrada: ");
        String nameIn = kb.nextLine();
        
	File fin = new File(nameIn); // Primeiro passo - associar um objeto File com o nome do ficheiro
	// A classe File permite ver e testar propriedades dos ficheiros, não os abre!
        
	if (!fin.exists()) {
            System.out.println("ERRO: ficheiro " + nameIn + " não existe!");
            System.exit(2);
        }
        if (fin.isDirectory()) {
            System.out.println("Ficheiro " + nameIn + " is a directory!");
	    listaDir(nameIn);
            System.exit(3);
        }
        if (!fin.canRead()) {
            System.out.println("ERRO: ficheiro " + nameIn+ "não pode ser lido!");
            System.exit(4);
        }
        System.out.println("Ficheiro válido!");

        System.out.print("Ficheiro de saida: ");
        String nameOut = kb.nextLine();
	
	// copia ficheiro de entrada para ficheiro de saida
	
        File fout = new File(nameOut);
    
        // Para LER um ficheiro, associa-o, através do objeto File, com a classe Scanner
	Scanner scf = new Scanner(fin);
        
	int cont = 0;
        // conta o numero de linhas do ficheiro
        while(scf.hasNextLine()) {
            cont++;
            scf.nextLine();
        }
        // cria array com tamanho do nº de linhas
        String[] linhas = new String[cont];

        scf.close(); // fecha ficheiro
	
	// É preciso fechar e abrir de novo para começar nova leitura a partir do início
	// lê ficheiro para array
	        
	scf = new Scanner(fin);

        for(int i = 0 ; i < cont ; i++) {
            String s = scf.nextLine();
            linhas[i] = s;
        }
        scf.close();
	
	// Para ESCREVER num ficheiro, associa-o, através do objeto File, com a classe PrintWriter
        PrintWriter pw = new PrintWriter(fout); 

        // escreve array com as linhas no ficheiro de escrita
        for(int i = 0 ; i < cont ; i++) {
            pw.println(linhas[i]);
        }
	    
        pw.printf("\n%10s \n%d\n", "Numero de linhas copiadas: ", cont);
        pw.close();
        // copiou os ficheiros
	
	// copia de novo e faz append!
	escreverFich(linhas, nameOut);
    }
    
    // métodos que usam ficheiros devem ser declarados com throws IOException
    public static void escreverFich(String[] linhas, String nameOut) throws IOException {
	 	
        // Em lugar da classe File pode usar-se a classe FileWriter
        //  que dá para abrir ficheiros em modo append.
        PrintWriter pw = new PrintWriter(new FileWriter(nameOut, true)); // true, abre em modo append
	int cont = linhas.length;
        // escreve array com as linhas no ficheiro de escrita
        for(int i = 0 ; i < cont ; i++) {
            pw.println(linhas[i]);
        }
	    
        pw.printf("\n%10s \n%d\n", "Numero de linhas copiadas: ", cont);
        pw.close();
    }
    
// lista diretório
    public static void listaDir(String nomeDir) {
        String[] lista;
        File fin1 = new File(nomeDir);
	if (fin1.isDirectory()){
	    lista = fin1.list();   // devolve array de strings com nomes ficheiro
	    for (String n : lista) {
		File f = new File(n);
		System.out.printf("%-30s %5s\n", n, f.isDirectory()? "DIR":f.length());
	    }
	}
    }
}


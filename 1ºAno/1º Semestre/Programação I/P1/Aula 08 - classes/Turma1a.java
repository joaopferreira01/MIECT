/* Aula 8 - Classes
 * JAM, 26-nov-2020
 *
 * Ler notas de 0 a 20 das várias avaliações de um aluno
 *  dados para cada aluno: id aluno, nome aluno, teste 1,teste 2
*/
import java.util.Scanner;

public class Turma1a {
    public static void main(String[] args) {

        final int NALUNOS = 5;
	int numAlunos = 0;
        // define ARRAY de 2 DIMENSOES (linhas = alunos; colunas = dados de um aluno)
        int[][] turma = new int[NALUNOS][3];

        //~ numAlunos = lerTurma(turma);
        //~ imprimirTurma(turma,numAlunos);
        // teste classe Aluno
	Aluno a = new Aluno();
	a.id = 111;
	a.nome = "ze";
	a.t1 = 11;
	a.t2 = 18;
	System.out.println(a.nome);
	Aluno[] t = new Aluno[10];
	t[0] = new Aluno();
	t[0] = a;
	System.out.println(t[0].nome);
	Aluno b = new Aluno(333, "ana", 11, 16);
	System.out.println(b.nome);
	imprimirTurma(t,1);
	numAlunos = lerTurma(t);
	imprimirTurma(t,numAlunos);
    }
    // funções para implementação com arrays de 2 dimensões
    static int lerTurma(int[][] t) {
        Scanner ler = new Scanner(System.in);
        int nalunos = 0;
        System.out.println("Introduza as notas dos alunos (ID = 0 termina):");
        System.out.printf("ID do aluno: ");
        int id = ler.nextInt();
        while (id > 0 && nalunos < t.length) {
            t[nalunos][0]=id;
            System.out.printf("Nota T1:");
            t[nalunos][1] = ler.nextInt();
            System.out.printf("Nota T2:");
            t[nalunos][2] = ler.nextInt();
            nalunos++;
            System.out.printf("ID do aluno: ");
            id = ler.nextInt();
        }
        return nalunos;
    }

    static void imprimirTurma(int[][] t, int n) {
        if (n < 0 || n > t.length)n = t.length;	//Testa limites array
        System.out.println("   ID   T1   T2 Final");
        for (int a = 0; a < n; a++) {
            for (int c = 0; c < t[a].length; c++)System.out.printf("%5d",t[a][c]);
            System.out.printf("%6.2f\n",(t[a][1]+t[a][2])/2.0);
        }
    }
    // funções implementadas com array de classe Aluno
     static int lerTurma(Aluno[] t) {
        Scanner ler = new Scanner(System.in);
        int nalunos = 0;
        System.out.println("Introduza as notas dos alunos (ID = 0 termina):");
        System.out.printf("ID do aluno: ");
        int id = ler.nextInt();
        while (id > 0 && nalunos < t.length) {
	    t[nalunos] = new Aluno();
            t[nalunos].id = id;
	     System.out.printf("Nome:");
            t[nalunos].nome = ler.next();
            System.out.printf("Nota T1:");
            t[nalunos].t1 = ler.nextInt();
            System.out.printf("Nota T2:");
            t[nalunos].t2 = ler.nextInt();
            nalunos++;
            System.out.printf("ID do aluno: ");
            id = ler.nextInt();
        }
        return nalunos;
    }
    
        static void imprimirTurma(Aluno[] t, int n) {
        if (n < 0 || n > t.length)n = t.length;	//Testa limites array
        System.out.println("   ID Nome       T1 T2 Final");
        for (int a = 0; a < n; a++) {
            System.out.printf("%5d %-10s %2d %2d",t[a].id, t[a].nome, t[a].t1, t[a].t2 );
            System.out.printf("%6.2f\n",(t[a].t1+t[a].t2)/2.0);
        }
    }
}
    //classes
class Aluno{
    int id;
    String nome;
    int t1;
    int t2;
    Aluno (){}
    Aluno (int nm, String n, int t1, int t2){
	this.id = nm;
	this.nome = n;
	this.t1 = t1;
	this.t2 = t2;
    }
}

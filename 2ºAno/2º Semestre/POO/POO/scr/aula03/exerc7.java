package aula03;
import java.util.Scanner;

public class exerc7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numero, contador=1;
        String resposta="S";
        int secret = (int)(100 * Math.random()) + 1;

        System.out.println(secret);

        do{
            numero = getNumber(sc, "Digite um número:");
            if(numero > secret){
                System.out.println("Alto!\n");
            }else if(numero < secret){
                System.out.println("Baixo!\n");
            }else{
                System.out.println("\nAcertaste em "+contador+" tentativas!\n");
                System.out.println("\nPretende continuar? Prima (S)im");
                resposta = sc.next();
            }
            contador++;
        }while(resposta.compareTo("S") == 0 || resposta.compareTo("Sim") == 0);

        sc.close();
    }
    public static int getNumber(Scanner sc, String text){
        int d;
        do {
            System.out.println(text);
            d = sc.nextInt();
            if(d > 100 || d <= 0){
                System.out.println("Número inválido!");
            }
        }while (d > 100 || d <= 0);
        return d;
    }    
}

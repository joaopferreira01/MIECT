package aula03;
import java.util.Scanner;

public class exerc8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double [][] notas = new double[16][3];

        for(int i = 0; i < notas.length; i++){
            notas[i][0] = 20*Math.random();
            notas[i][1] = 20*Math.random();
            notas[i][2] = (int) Math.round(0.4*notas[i][0] + 0.6*notas[i][1]);
            if(notas[i][0] < 7 || notas[i][1] < 7){
                notas[i][2] = 66;
            }
        }
        System.out.println("NotaT   NotaP   Pauta");
        
        for(int i = 0; i < notas.length; i++){
            System.out.printf("%4.1f    %4.1f    %4.0f\n",notas[i][0],notas[i][1],notas[i][2]);
            
        }
        sc.close();
    }    
}

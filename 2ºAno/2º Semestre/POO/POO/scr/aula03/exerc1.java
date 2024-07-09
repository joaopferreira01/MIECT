package aula03;
import java.util.Scanner;

public class exerc1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double p,t,grade;

        t = getGrade(sc, "Digite a nota teórica do aluno:");
        p = getGrade(sc, "Digite a nota prática do aluno:");

        while(true){
            if(p < 7 || t < 7){
                System.out.println("Este aluno está reprovado por nota mínima!");
                break;
            }else{
                grade = (0.4*t)+(0.6*p);
                System.out.printf("\nA nota nota deste aluno é: %.1f",grade);
                break;
            }
        }
        sc.close();
    }
    public static Double getGrade(Scanner sc, String msg){
        double d = 0;
        do {
            System.out.println(msg);
            d = sc.nextDouble();
            if(d < 0 || d > 20) {
                System.out.println("A nota tem que estar no intervalo [0..20]");
            }

        } while (d < 0 || d > 20);
        return d;
    }
}

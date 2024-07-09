package aula04;
import java.util.Scanner;

public class exerc4 {
    public static void main (String[] args){
        String[] Months = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        Scanner sc = new Scanner(System.in);

        System.out.println("Month:");
        int mes = sc.nextInt();
        System.out.println("Year:");
        int ano = sc.nextInt();
        System.out.println("Weekday(1-7):");
        int dia = sc.nextInt();

        System.out.println("   "+Months[mes-1]+" "+ano);
        System.out.println("Su Mo Tu We Th Fr Sa");
        
        for(int i = 0; i < dia;i++){
            if(dia == 7){
                break;
            }
            System.out.print("   ");
        }
        
        for(int i = 1; i<=getMonthDay(ano,mes);i++){
            System.out.printf("%2d ",i);
            if( (dia + i) % 7 == 0){
                System.out.println();
            }
        }
        System.out.println("\n");
        sc.close();
    }
    public static int getMonthDay(int ano,int mes ){
        int[] Dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))) {
            Dias[1] = 29;
        }
        return Dias[mes-1];
    }
}

package aula03;
import java.util.Scanner;

public class exerc6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int mes,ano;
        while(true){
            System.out.println("Digite o número do mês:");
            mes = sc.nextInt();
            if(mes >= 1 && mes <= 12){
                break;
            }
        }
        while(true){
            System.out.println("Digite o ano:");
            ano = sc.nextInt();
            if(ano >= 1){
                break;
            }
        }
        if ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))) {
            dias[1] = 29;
        }
        System.out.println("O número de dias do mês "+mes+" do ano "+ano+" é: "+(dias[mes-1]));
        sc.close();
    }
}

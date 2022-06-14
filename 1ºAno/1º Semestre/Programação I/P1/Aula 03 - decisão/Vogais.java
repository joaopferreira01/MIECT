/* JAM, 3-out-2019
 * determinar se um caracter é vogal
 */
import java.util.Scanner;
public class Vogais {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        char letra;
       
        System.out.println("Introduza um caracter:");
        letra = ler.next().charAt(0);
	System.out.printf("Codigo do %c = %d\n", letra,(int)letra);
        switch (letra) {
	    case '1':
		System.out.printf("digito%n");
		break;
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.printf("Vogal %c %n", (letra-('a'-'A')));
                break;
            case '3':
		System.out.printf("tres%n");
		break;
	    default:
                System.out.printf("Consoante%n");
                break;
        }
    }
}

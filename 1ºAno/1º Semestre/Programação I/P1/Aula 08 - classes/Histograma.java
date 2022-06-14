/* Aula 8, JAM, 19-nov-2020
 * - CLASSES
 */
import java.util.Scanner;

public class Histograma {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
	char[] letras = {'a', 'c', 't', 'c', 'c', 'a'};

        // cálculo do histograma
        System.out.printf("Histograma:%n");
        Letra[] histo;
        histo = hist(letras,letras.length);
        // imprime histograma
        for (int i = 0; i < histo.length; i++)
            System.out.printf("%c %3d %n",histo[i].c,histo[i].count);
    }
    //
    // f histograma
    // find - procura no array a, de comprimento n, o char v
    static int find(Letra[] a, int n, char v) {
        int indice = -1;    // não encontrou valor
        for (int i = 0; i < n; i++) {
            if(a[i].c == v) indice = i;
        }
        return indice;
    }
    static Letra[] hist(char[] a, int n) {
        int nc=0;
        Letra[] h = new Letra[a.length];
        for (int i = 0; i < n; i++) {
            int indice = find(h,nc,a[i]);
            if ( indice == -1) { // cria novo num
		h[nc] = new Letra();
                h[nc].c = a[i];
                h[nc].count = 1;
                nc++;
            } else {             // num existe, atualiza freq
                h[indice].count++;
            }
        }
        // devolve array completo, só com letras válidas
        Letra[] h2 = new Letra[nc];
        System.arraycopy(h,0,h2,0,nc);
        return h2;
    }
}
class Letra {
    char c;
    int count;
}

package aula06;
import java.util.Scanner;;

public class Ex1 {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Aluno al = new Aluno ("Andreia Melo", 9855678,
        new Date(18, 7, 1990), new Date(1, 9, 2018));
        Bolseiro bls = new Bolseiro ("Igor Santos", 8976543, new Date(11, 5, 1985), 900);
        bls.setBolsa(1050);

        System.out.println("Aluno: " + al.getNome());
        System.out.println(al);

        System.out.println("Bolseiro: " + bls.getNome() + ", NMec: "
        + bls.getNMec() + ", Bolsa: " + bls.getBolsa());
        System.out.println(bls);
    }
}

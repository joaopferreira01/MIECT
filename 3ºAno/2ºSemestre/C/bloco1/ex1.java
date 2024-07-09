import java.util.Arrays;
import java.util.Scanner;

class ex1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String  a = sc.nextLine();
        String[] k=a.split(" ");
        double n = Double.parseDouble(k[0]);
        double  m = Double.parseDouble(k[2]);
        System.out.println(Arrays.toString(k)); // print array

        String op = k[1];
        if (op.equals("+")){
            System.out.println(n+m);
        }else if (op.equals("-")){
            System.out.println(n-m);
        }else if (op.equals("*")){
            System.out.println(n*m);
        }else if (op.equals("/")){
            System.out.println(n/m);
        }else{
            System.err.println("Invalid operator");
        }
        sc.close();

    }
}
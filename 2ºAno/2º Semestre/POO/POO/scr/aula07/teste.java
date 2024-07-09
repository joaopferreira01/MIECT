package aula07;

public class teste {
    public static void main(String [] args){
        String s1 = "1234";
        System.out.println(s1.matches("\\d{2,4}"));
        int a = 10;
        double x = 5.5;
        System.out.println(x / a);
        System.out.println((int)x*a);
        double r = 0;
        for(int i = 1; i <= a; i++){
            if(i % 5 == 0){
                r += x * (i/5);
                System.out.println(r);
            }
        }
    }
}

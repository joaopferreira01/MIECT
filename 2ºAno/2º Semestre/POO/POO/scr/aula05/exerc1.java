package aula05;
import java.util.*;

public class exerc1 {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Data data1 = new Data(10,1,2002);

        loop: while(true){
            System.out.println("\nDate operations: ");
            System.out.println("1 - create new date"); 
            System.out.println("2 - show current date");
            System.out.println("3 - increment date");
            System.out.println("4 - decrement date");
            System.out.println("0 - exit\n");
            System.out.print("Option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nDay:");
                    int day = sc.nextInt();
                    System.out.println("Month:");
                    int month = sc.nextInt();
                    System.out.println("Year:");
                    int year = sc.nextInt();
                    data1 = new Data(day, month, year);
                    break;
                case 2:
                    System.out.println("\nCurrent date: ");
                    System.out.println(data1);
                    break;
                case 3:
                    System.out.println("Number of days: ");
                    int days = sc.nextInt();
                    data1.increment(days);
                    break;
                case 4:
                    System.out.println("Number of days: ");
                    days = sc.nextInt();
                    data1.decrement(days);
                    break;
                case 0:
                    break loop;
            }
        }
    }    
}
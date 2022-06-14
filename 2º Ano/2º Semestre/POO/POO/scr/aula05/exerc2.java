package aula05;
import java.util.*;
public class exerc2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Calendar cal1 = new Calendar(2,2002);

        loop: while(true){
            System.out.println("\nCalendar operations:");
            System.out.println("1 - create new calendar"); 
            System.out.println("2 - print calendar month");
            System.out.println("3 - print calendar");
            System.out.println("0 - exit\n");
            System.out.print("Option: ");
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println("\nWeekDay:");
                    int weekDay = sc.nextInt();
                    System.out.println("Year:");
                    int year = sc.nextInt();
                    cal1 = new Calendar(weekDay,year);
                    break;
                case 2:
                    System.out.println("\nMonth: ");
                    int month = sc.nextInt();
                    cal1.printMonth(month);
                    break;
                case 3:
                    System.out.println(cal1);
                    break;
                case 0:
                    break loop;
            }
        }


        sc.close();
    }
    
}

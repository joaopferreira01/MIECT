package aula06;

public class Date {

    private int day, month, year; // Se forem private criar " public static getDay(){return data} "
    public static final int dias[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int day, int month, int year){
        this.set(day, month, year);
    }
    public static boolean validMonth(int month){
        return month >= 1 && month <= 12;
        
    }
    public static int monthDays(int month, int year){
        if (leapYear(year) && month == 2){
           return 29;
        }
        return dias[month-1];
    
    }
    public static boolean leapYear(int year){
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }
    public static boolean valid(int day, int month, int year){
        return validMonth(month) && (day >= 1 && day <= monthDays(month, year));
    }
    public void set(int day, int month, int year){
        if(valid(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
            return;
        }
        System.out.println("Data Inválida!");
    }
    public void increment(int days){
            while(days > 0){
                this.day++;
                if(this.day > monthDays(this.month, this.year) && this.month >= 12){
                    this.day = 1;
                    this.month = 1;
                    this.year++;
                }else if(this.day > monthDays(this.month, this.year) && this.month < 12){
                    this.day = 1;
                    this.month++;
                }
                days--;
            }
    }
    public void decrement(int days){ // Esta função faz a quantidade de dias dados pelo teclado
        while(days > 0){
            if(this.day == 1 && this.month != 1){
                this.day = monthDays(this.month-1, this.year);
                this.month--;
            }else if(this.day == 1 && this.month == 1){
                this.day = monthDays(12, this.year);
                this.month = 12;
                this.year--;
            }
            else{
                this.day--;
            }
            days--;
        }
    }
    public String toString(){
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }
    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
}
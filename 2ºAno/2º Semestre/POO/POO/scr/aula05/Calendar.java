package aula05;


public class Calendar {
    private int weekDayOfYear, year, weekDayOfMonth;
    public static final String Mes[] = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};

    public Calendar(int weekDay, int year){
        if(validWeekDay(weekDay)){
            this.weekDayOfYear = weekDay;
            this.year = year;
        }
    }

    public boolean validWeekDay(int weekDay){
        return weekDay >= 1 && weekDay <= 7;
    }

    public int firstWeekDayOfYear(){
        return this.weekDayOfYear;
    }

    public int year(){
        return this.year;
    }

    public int firstWeekDayOfMonth(){
        return this.weekDayOfMonth;
    }


    public String printMonth(int month){
        
        System.out.println("   "+Mes[month-1]+" "+this.year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        for(int i = 0; i < this.weekDayOfYear-1;i++){
            if(this.weekDayOfYear == 1){
                break;
            }
            System.out.print("   ");
        }
        
        /*int x = this.weekDayOfYear+Data.monthDays(month, this.year);
        x = x/5;
        if(x % 7 != 0){
            x = x-1;
        }else if(x % 7 == 0){
            //System.out.println();
        }*/
        for(int i = 1; i <= Data.monthDays(month, this.year);i++){
            System.out.printf("%2d ",i);
            if((this.weekDayOfYear - 1 + i) % 7 == 0){
                System.out.println();
            }
        } 
        //int x = i+this.weekDayOfYear;
        
        
        /*this.weekDayOfYear = x;
        if((this.weekDayOfYear+i)==7){
            this.weekDayOfYear = 0;
        }
        this.weekDayOfMonth = this.weekDayOfYear++;*/
        System.out.println();
        return "";
    }
    public String toString(){
        String r = "";
        for(int i = 1; i <= 12; i++){
            r += printMonth(i);
            System.out.println();
            /*if(this.weekDayOfMonth % 7 == 0){
                this.weekDayOfYear = this.weekDayOfYear/7;
            }else{
                this.weekDayOfYear = (this.weekDayOfYear/7) + 1;
            }*/

        }
        return r;
    }
}

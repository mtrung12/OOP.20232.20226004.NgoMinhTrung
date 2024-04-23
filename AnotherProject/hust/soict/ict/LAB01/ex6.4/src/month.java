import java.util.Scanner;
import java.util.Arrays;
public class month {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year=-1;
        int leapTest=0;
        String m;
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December",
        "Jan.","Feb.","Mar.","Apr.","May","June","July","Aug.","Sept.","Oct.","Nov.","Dec.",
        "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec",
        "1","2","3","4","5","6","7","8","9","10","11","12"};
        while(true){
            System.out.print("Enter a year: ");
            year = sc.nextInt();
            if(year>=0) break;
            else System.out.println("Invalid Input! Please enter again.");
        }
        System.out.print("Enter a month: ");
        while(true){
            m = sc.next();
            if(!Arrays.asList(months).contains(m)){
                System.out.println("Invalid Month Input!\nPlease enter again:");
                continue;
            }
            else break;
        }
        switch(m){
            case "January","Jan.","Jan","1","March","Mar.","Mar","3","May","5","July","Jul","7","August","Aug.","Aug","8",
            "October","Oct.","Oct","10","December","Dec.","Dec","12":
            System.out.println("This month has 31 days");
            break;
            case "February", "Feb", "Feb.", "2":
            if(year%4==0){
                if(year%100==0&&year%400==0)
                    leapTest=0;
                else 
                    leapTest=1;
            }
            if(leapTest==1) 
                System.out.print("This month has 29 days");
            else 
                System.out.print("This month has 28 days");
            break;
            default:
            System.out.print("This month has 30 days");
            break;
        }
        
        
        
        
    }
}

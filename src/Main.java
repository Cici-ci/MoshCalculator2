import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
  {
      int principal=(int)readNumber("Enter the principal: ",1000,1_000_000);
      float annualInternet=(float)readNumber("Enter the Annual Internet Rate: ",1,30);
      byte years=(byte) readNumber("Period(Years): ",1,30);
      System.out.println(NumberFormat.getCurrencyInstance().format(calculateMortgage(principal,annualInternet,years)));

   }
    public static double readNumber(String prompt,double min,double max){
        double value;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value>=min&&value<=max)
                break;
            System.out.println("Enter the value between" +min+"and "+max);
        }
        return value;
    }
    public static double calculateMortgage(int principal,float annualInterest,byte years){
        final byte MONTH_IN_YEAR=12;
        final byte  PERCENT=100;

        double monthInterestRate=annualInterest/MONTH_IN_YEAR/PERCENT;
        double months=years*MONTH_IN_YEAR;
        double mortgage=principal*monthInterestRate*Math.pow(1+monthInterestRate,months)
                /(Math.pow(1+monthInterestRate,months)-1);
        return mortgage;

    }
}
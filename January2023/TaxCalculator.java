import java.util.Scanner;

public class TaxCalculator {
   public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)){
        System.out.print("Enter your annual income: ");
        int income = sc.nextInt();

        if(income<500000){
            System.out.println("You do not have to pay Income Tax.");
        } else if(income>=500000 && income<1000000){
            int tax = (int) (income *0.2);
            System.out.println("You have to pay "+tax+"Rs as an Income Tax.");
        }else{
            int tax = (int) (income*0.3);
            System.out.println("You have to pay "+tax+"Rs as an Income Tax.");
        }

       
    }
   } 
}

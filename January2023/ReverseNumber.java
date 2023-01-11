import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the number you want to reverse: ");
            int number = sc.nextInt();

            while(number>0){

                int lastDigit = number%10;
                System.out.print(lastDigit);
                number/=10;
                

            }

        }
    }
}

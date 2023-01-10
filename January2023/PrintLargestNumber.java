import java.util.Scanner;

public class PrintLargestNumber {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the first number: ");
            int a = sc.nextInt();
            System.out.print("Enter the second number:  ");
            int b = sc.nextInt();

           if(a>b){
            System.out.println("The largest number is: "+a);
           } else{
            System.out.println("The largest number is: "+b);
           }

        }
    }
}

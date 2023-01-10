import java.util.Scanner;

public class Function2 {
    public static int factorial(int n){
        int fact = 1;

        for(int i=1;i<=n;i++){
            fact = fact*i;
        }

        return fact;


    }
    public static void main(String[] args) {
        System.out.print("Enter the number: ");
        try(Scanner sc = new Scanner(System.in)){
            int n = sc.nextInt();
            System.out.println("The Factorial of "+n+" is: "+factorial(n));

        }
    }
}

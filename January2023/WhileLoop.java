import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the range: ");
            int range = sc.nextInt();
            int n = 1;
            int sum = 0;
            int factorial = 1;
            while(n<=range){
                    System.out.println("Hello World");
                    System.out.println("Number: "+n);
                    sum+=n;
                    System.out.println("Sum: "+sum);
                    factorial*=n;
                    System.out.println("Factorial: "+factorial);
                    n++;

            }
        }

    }
}

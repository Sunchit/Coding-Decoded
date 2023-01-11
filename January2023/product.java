import java.util.Scanner;

public class product {
public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)){
        System.out.print("Enter the First Number: ");
        int a = sc.nextInt();
        System.out.print("Enter the Second Number: ");
        int b = sc.nextInt();

        int product = a * b;

        System.out.println("The Product of two number is: "+product);

    }
}
}

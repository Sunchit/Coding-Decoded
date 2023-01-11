import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
       try (Scanner sc = new Scanner(System.in)) {
        System.out.print("Enter the First Number: ");
        int a = sc.nextInt();
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();

        int sum = a + b;
        System.out.println("The sum of First and Second Number is: "+sum);
    }

    }
}

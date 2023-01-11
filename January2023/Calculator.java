import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the First Number: ");
            int a = sc.nextInt();
            System.out.print("Enter the Second Number: ");
            int b = sc.nextInt();
            System.out.print("Choose your operator + - * /: ");
            char operator = sc.next().charAt(0);

            switch(operator){
                case '+': System.out.println(a+b);
                break;
                case '-':System.out.println(a-b);
                break;
                case '*': System.out.println(a*b);
                break;
                case '/': System.out.println(a/b);
                break;
            }
        }
       

    }
}

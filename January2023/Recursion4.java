import java.util.Scanner;

public class Recursion4 {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the number: ");
            int n = sc.nextInt();
           System.out.println(fib(n));
        }
    }

    public static int fib(int n){
        if(n==0||n==1){
            return n;
        }
        int fibnm1 = fib(n-1);
        int fibnm2 = fib(n-2);
        int fibn = fibnm1+fibnm2;

        return fibn;
    }
}

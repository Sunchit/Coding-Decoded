import java.util.Scanner;

public class Recursion {
    
    public static void decreasingNumber(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        decreasingNumber(n-1);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number: ");
            int n = sc.nextInt();
            decreasingNumber(n);
        }
    }

}

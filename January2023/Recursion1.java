import java.util.Scanner;

public class Recursion1 {

    public static void increasingNumber(int n){
       if(n==1){
        System.out.println(n);
        return;
       }
      increasingNumber(n-1);
      System.out.println(n);
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int n = sc.nextInt();
            increasingNumber(n);
        }
    }
}

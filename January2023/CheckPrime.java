import java.util.Scanner;

public class CheckPrime {




    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Enter the number: ");
            int n = sc.nextInt();

         boolean isPrime = true;

         for(int i=2;i<=n-1;i++){
            if(n%i==0){
                isPrime = false;
            }

         }

         if(isPrime==true){
            System.out.println("It is a Prime Number");
         }else{
            System.out.println("It is not a Prime Number.");
         }

        }
    }
}

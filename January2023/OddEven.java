import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Enter the number: ");
            int n = sc.nextInt();

            if(n%2==0){
                System.out.println("It is an even number");
            }else{
                System.out.println("It is an odd number");
            }

        }
    }
}

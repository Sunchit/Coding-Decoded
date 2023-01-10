import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the number of rows: ");

            int n = sc.nextInt();

            for(int i=n;i>0;i--){

                for(int j=1;j<=i;j++){
                    System.out.print(j+" ");
                }
                System.out.println();
            }

        }
    }
}

import java.util.Scanner;

public class Pattern13 {
    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the number of rows: ");
            int n = sc.nextInt();

            // 1st half
            for(int i=1;i<=n;i++){
                for(int j=1;j<=(n-i);j++){
                    System.out.print(" ");
                }
                for(int j=1;j<=(2*i)-1;j++){
                    System.out.print("*");
                }
                System.out.println();
            }


            // 2nd Half

            for(int i=n;i>0;i--){
                for(int j=1;j<=(n-i);j++){
                    System.out.print(" ");
                }
                for(int j=1;j<=(2*i)-1;j++){
                    System.out.print("*");
                }
                System.out.println();
            }

        }

    }
}

import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the length of the square = ");
            int line = sc.nextInt();

      for(int i=0;i<line;i++){

            for(int j=0;j<line;j++){
                System.out.print("*");
            }
      System.out.println();

      }
        }


       }
}

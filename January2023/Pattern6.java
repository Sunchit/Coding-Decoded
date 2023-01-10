import java.util.Scanner;

/**
 * Pattern6
 */
public class Pattern6 {

    public static void hollowRectangle(int totalRow,int totalCol){

        for(int i=1;i<=totalRow;i++){

            for(int j=1;j<=totalCol;j++){

                if(i==1||i==totalRow||j==1||j==totalCol){
                    System.out.print("*");

                }
                else{
                    System.out.print(" ");
                }

            }
                System.out.println();
        }

    }

    public static void main(String[] args) {
  
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the number of rows: ");
            int row = sc.nextInt();
            System.out.print("Enter the number of columns: ");
            int columns = sc.nextInt();
            hollowRectangle(row, columns);
        }

    }
}
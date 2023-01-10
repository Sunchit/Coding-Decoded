import java.util.Scanner;

public class Matrices {


    public static boolean search(int matrix[][], int key){

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==key){
                    System.out.println("Fount at cell ("+i+","+j+")");
                    return true;
                }
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];  

        int n = 3, m = 3;
        
        try (Scanner sc = new Scanner(System.in)) {
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
       search(matrix, 6);
       

    }
}

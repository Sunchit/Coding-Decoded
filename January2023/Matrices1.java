public class Matrices1 {

    // Spiral Matrix

    public static void printSpiral(int matrix[][]){
        int startRow = 0;
        int startCol = 0;

        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while (startRow<=endRow && startCol<=endCol) { 
         // Print Top Boundary

         for(int i = startCol;i<=endCol;i++){
            System.out.print(matrix[startRow][i]+" ");
         }
        // print end column
         for(int i = startRow+1;i<=endRow;i++){
            System.out.print(matrix[i][endCol]+" ");
         }
         //print bottom row

         for(int i=endCol-1;i>=startCol;i--){
            System.out.print(matrix[endRow][i]+" ");
         }
         // print start column

         for(int i=endRow-1;i>=startRow+1;i--){
            System.out.print(matrix[i][startCol]+" ");
         }
         startRow++;
         endRow--;
         startCol++;
         endCol--;

        }

    }

    public static void main(String[] args) {

        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};


                          printSpiral(matrix);

        
    }
}

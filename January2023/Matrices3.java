public class Matrices3 {

    // Search in Sorted Matrix 

    public static boolean stairCaseSearch(int matrix[][],int key){
        int row=0, col = matrix[0].length-1;
        
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==key){
                System.out.println("Found Key at("+row+","+col+")");
                return true;
            }else if(key<matrix[row][col]){
                col--;
            }else{
                row++;
            }



        }

       System.out.println("Key Not Found");
       return true;

    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        int key = 19;

        stairCaseSearch(matrix, key);
        
    }
}

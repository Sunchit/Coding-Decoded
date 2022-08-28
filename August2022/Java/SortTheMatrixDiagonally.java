
// @saorav21994
// 2 way solution

/*
    We know that same diagonal have same difference between row and column numbers.
    Using PriorityQueue with HashMap -> Generic solution.
*/

// TC : O(r*c*log(max diagonal element in any diagonal))

/*
class Solution {
    
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    
    public int[][] diagonalSort(int[][] mat) {
        constructMap(mat);
        
        int r = mat.length, c = mat[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = map.get(i-j).poll();
            }
        }
        
        return mat;
        
    }
    
    public void constructMap(int [][] mat) {
        
        int r = mat.length;
        int c = mat[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map.computeIfAbsent((i-j), param -> new PriorityQueue<Integer>()).add(mat[i][j]);
            }
        }
        
    }
    
    
}
*/



/*
    For this question, as the range of number of mat[][] is <= 100, counting sort can be used to reduce time complexity.
    
*/

// TC : O(r*c)


class Solution {
        
    public int[][] diagonalSort(int[][] mat) {
        
        int r = mat.length;
        int c = mat[0].length;
        
        for (int i = 0; i < c; i++) {
            sortElement(mat, 0, i);     // by fisrt row
        }
        for (int i = 1; i < r; i++) {
            sortElement(mat, i, 0);     // by first column
        }
        
        return mat;        
    }
    
    public void sortElement(int [][] mat, int i, int j) {
        
        int r = i;
        int c = j;
        
        int [] count = new int[101];
        
        while (r < mat.length && c < mat[0].length) {
            count[mat[r++][c++]] += 1;
        }
        
        r = i; c = j;
        
        for (int k = 0; k <= 100; k++) {
            while (count[k] > 0) {
                mat[r++][c++] = k;
                count[k] -= 1;
            }
        }
        
    }
    
    
}

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return ans;
        }

        int startRow = 0;
        int endRow = matrix.length-1;
        int startColumn = 0;
        int endColumn = matrix[0].length - 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            // Move towards right
            for (int j = startColumn; j <= endColumn; j ++) {
                ans.add(matrix[startRow][j]);
            }
            startRow++;

            // Move towards down
            for (int i = startRow; i <= endRow; i ++) {
                ans.add(matrix[i][endColumn]);
            }
            endColumn--;

            if (startRow <= endRow) {
                // Move towards left
                for (int j = endColumn; j >= startColumn; j --) {
                    ans.add(matrix[endRow][j]);
                }
            }
            endRow--;

            if (startColumn <= endColumn) {
                // Move towards top
                for (int i = endRow; i >= startRow; i --) {
                    ans.add(matrix[i][startColumn]);
                }
            }
            startColumn ++;
        }

        return ans;
    }

}
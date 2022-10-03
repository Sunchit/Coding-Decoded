// https://leetcode.com/problems/maximum-sum-of-an-hourglass/
// @author: anuj0503
class Solution {
    int[][] dir = new int[][]{{0,0}, {-1, -1}, {-1, 0}, {-1, 1}, {1, 0}, {1, 1}, {1, - 1}};
    public int maxSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int result = 0;
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m -1; j++){
                int sum = 0;

                for(int[] d : dir){
                    int newX = d[0] + i;
                    int newY = d[1] + j;

                    sum += grid[newX][newY];
                }

                result = Math.max(result, sum);
            }
        }

        return result;
    }
}

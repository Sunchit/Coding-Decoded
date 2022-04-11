
// @saorav21994
// TC : O(n^2)  
// SC : O(n^2) 

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ele = m * n;
        k = k % ele;
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int idx = findShiftedIndex(i, j, n, k, ele);
                sublist.add(grid[idx/n][idx%n]);
            }
            res.add(sublist);
        }
        
        return res;
    }
    
    public int findShiftedIndex(int i, int j, int col, int k, int ele) {
        return (i * col + j - k + ele) % ele;
    }
}

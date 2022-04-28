
// @saorav21994
// DFS + Binary Search. But this can be done more easily using BFS + PriorityQueue.
// SC : O(m*n)
// TC : O(m*n*log(max sum of any two values))


class Solution {
    
    int [][] adjust = {{1,0},{-1,0},{0,-1},{0,1}};
    int [][] vis = new int[102][102];
        
    void dfs(int x, int y, int mid, int [][] heights) {
        if (vis[x][y] != 1) {
            vis[x][y] = 1;
            int r = heights.length;
            int c = heights[0].length;
            for (int i = 0; i < 4; i++) {
                int X = x+adjust[i][0];
                int Y = y+adjust[i][1];
                if (X < 0 || X >=r || Y < 0 || Y >= c) 
                    continue;
                if (Math.abs(heights[x][y]-heights[X][Y]) <= mid) 
                    dfs(X,Y,mid,heights);
            }
        }
    }
    
    void fillup(int [][]vis, int data) {
        for (int i = 0; i < 102; i++) {
            Arrays.fill(vis[i], data);
        }
    }
    
    public int minimumEffortPath(int[][] heights) {
        int l = 0, r = 1000000+11;
        int m = heights.length;
        int n = heights[0].length;
        while (l < r) {
            int mid= (l+r)/2;
            fillup(vis, 0);
            dfs(0,0,mid,heights);
            if (vis[m-1][n-1] == 1) 
                r = mid;
            else
                l = mid+1;
        }
        return l;
    }
}

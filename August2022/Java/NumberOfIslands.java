
// @saorav21994
// TC : O(n^2)
// SC : O(n^2)

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    Queue<coor> queue = new LinkedList<>();
                    grid[i][j] = '2';
                    coor xy = new coor(i, j);
                    queue.offer(xy);
                    while (!queue.isEmpty()) {
                        coor cxy = queue.poll();
                        int x = cxy.x;
                        int y = cxy.y;
                        // grid[x][y] = '2';    // cell traversed
                        if (y+1 < n && grid[x][y+1] == '1') {
                            queue.offer(new coor(x, y+1));
                            grid[x][y+1] = '2';
                        }
                        if (x+1 < m && grid[x+1][y] == '1') {
                            queue.offer(new coor(x+1, y));
                            grid[x+1][y] = '2';
                        }
                        if (x-1 >= 0 && grid[x-1][y] == '1') {
                            queue.offer(new coor(x-1, y));
                            grid[x-1][y] = '2';
                        }
                        if (y-1 >= 0 && grid[x][y-1] == '1') {
                            queue.offer(new coor(x, y-1));
                            grid[x][y-1] = '2';
                        }
                    }
                    res += 1;
                }
            }
        }
        return res;
    }
    
    public class coor {
        int x;
        int y;
        
        public coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

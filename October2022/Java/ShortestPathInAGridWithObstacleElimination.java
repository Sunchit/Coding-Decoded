// @saorav21994

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int [][] stops = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(stops[i], -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int [] {0, 0, k, 0});
        while (queue.isEmpty() != true) {
            int [] top = queue.poll();
            int x = top[0];
            int y = top[1];
            int remain = top[2];
            int dist = top[3];
            
            if (x == m-1 && y == n-1)
                return dist;
            
            if (stops[x][y] >= remain)
                continue;
            
            stops[x][y] = remain;
            
            for (int [] d : dir) {
                int x1 = x + d[0];
                int y1 = y + d[1];
                if (x1 >= 0 && x1 < m &&  y1 >= 0 && y1 < n) {
                    
                    if (grid[x1][y1] == 1 && remain <= 0)
                        continue;       // not possible
                    
                    if (grid[x1][y1] == 1) {
                        queue.offer(new int [] {x1, y1, remain-1, dist+1});
                    }
                    else {
                        queue.offer(new int [] {x1, y1, remain, dist+1});
                    }
                    
                }
            } 
            
            
        }
        
        return -1;
        
    }
}

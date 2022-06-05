class Solution {
    private static final int[][] directions = {{0,1},{0,-1}, {1,0},{-1,0}};

    private int[][] dist = null;

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dist = new int[m][n];

        for (int[] disArray : dist) {
            Arrays.fill(disArray, Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2] - b[2]));
        // X, Y, Distance
        pq.offer(new int[]{ 0,  0, dist[0][0]});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int x = cur[0];
            int y = cur[1];
            int currCost = cur[2];

            if (x == m - 1 && y == n - 1) {
                return currCost;
            }

            for (int[] dir : directions) {

                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (nextX >=0 && nextX<m && nextY >=0 && nextY<n && currCost + grid[nextX][nextY] < dist[nextX][nextY]) {
                    dist[nextX][nextY] = currCost + grid[nextX][nextY];
                    pq.offer(new int[]{nextX, nextY,dist[nextX][nextY]});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
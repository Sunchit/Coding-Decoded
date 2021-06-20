class Solution {

    // TC : O(n2logn)
    private class Tile {
        private int x;
        private int y;
        private int time;
        public Tile(int x, int y, int time){
            this.x= x;
            this.y= y;
            this.time = time;

        }
    }

    private static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    public int swimInWater(int[][] grid) {
        int n=grid.length;

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Tile> pq = new PriorityQueue<>((a,b)->a.time - b.time);

        pq.add(new Tile (0,0,grid[0][0]));

        int leastTime = grid[0][0];
        visited[0][0] = true;


        while (!pq.isEmpty()) {
            Tile currTile = pq.poll();

            leastTime = Math.max(currTile.time, leastTime);
            //System.out.println(leastTime);
            // Finish point
            if (currTile.x == n - 1 && currTile.y == n - 1) {
                break;
            }

            for (int[] dir : directions) {

                int nextX = currTile.x + dir[0];
                int nextY = currTile.y + dir[1];

                if (nextX < 0 ||  nextX >= n  || nextY < 0  || nextY >= n || visited[nextX][nextY]) {
                    continue;
                }
                visited[nextX][nextY] = true;
                pq.add(new Tile(nextX, nextY, grid[nextX][nextY]));
            }


        }

        return leastTime;
    }
}
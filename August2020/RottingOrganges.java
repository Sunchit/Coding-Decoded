class Solution {

    private class Point {
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    // BFS traversal Graph solution
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if(n==0 || m==0){
            return -1;
        }

        Queue<Point> qu = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    qu.offer(new Point(i, j));
                }
            }
        }

        int level =0;
        while(!qu.isEmpty()) {
            int size = qu.size();
            while(size-->0){
                Point head = qu.poll();
                int i = head.x;
                int j = head.y;

                if(i<0 || j<0 || i>=n || j>=m || grid[i][j] <=0){
                    continue;
                }
                grid[i][j] = -1;

                if(i>=1 && grid[i-1][j]==1){
                    grid[i-1][j] = 3; // rotton organes will be treated with no 2, 3
                    qu.offer(new Point(i-1,j));
                }


                if(i<n-1 && grid[i+1][j]==1){
                    grid[i+1][j] = 3; // rotton oranges will be treated with no 2, 3
                    qu.offer(new Point(i+1,j));
                }

                if(j>=1 && grid[i][j-1]==1){
                    grid[i][j-1] = 3; // rotton oranges will be treated with no 2, 3
                    qu.offer(new Point(i,j-1));
                }



                if(j<m-1 && grid[i][j+1]==1){
                    grid[i][j+1] = 3; // rotton oranges will be treated with no 2, 3
                    qu.offer(new Point(i,j+1));
                }
            }
            level++;
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        // [[0]]
        return level>0 ? level-1 : 0;
    }
}


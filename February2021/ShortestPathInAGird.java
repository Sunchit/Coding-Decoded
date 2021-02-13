class Solution {

    private class Point{
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length -1;
        if(grid[0][0] ==1 || grid[n][n] ==1){
            return -1;
        }
        int level = 0;
        Queue<Point> qu =new LinkedList<>();
        qu.offer(new Point(0,0));
        while(!qu.isEmpty()){
            int size= qu.size();
            while(size-->0){
                Point head = qu.poll();
                int x = head.x;
                int y = head.y;

                if(x == n && y ==n ){
                    return level+1;
                }

                if(x < 0 || y<0 || x>n || y >n || grid[x][y] >=1){
                    continue;
                }

                grid[x][y] = 2;
                qu.offer(new Point(x-1, y));
                qu.offer(new Point(x+1, y));
                qu.offer(new Point(x, y-1));
                qu.offer(new Point(x, y+1));


                qu.offer(new Point(x-1, y-1));
                qu.offer(new Point(x-1, y+1));
                qu.offer(new Point(x+1, y-1));
                qu.offer(new Point(x+1, y+1));

            }
            level++;
        }
        return -1;
    }
}
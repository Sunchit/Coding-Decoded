
// @saorav21994
// TC : O(n^2)
// SC : O(n^2)    // for visited matrix
// BFS used

class Solution {
    
    // Using BFS approach
    
    class Point {
        int x;
        int y;
        int distance;
        
        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        
    }
    
    // all possible 8 directions
    int [][] dir = {{0,-1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        Queue<Point> queue = new LinkedList<>();
        
        if (grid[0][0] == 1)
            return -1;
        
        boolean [][] visited = new boolean[n][n];
        
        queue.offer(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            
            Point curPoint = queue.poll();
            
            int curPointx = curPoint.x;
            int curPointy = curPoint.y;
            int curDistance = curPoint.distance;
            
            if (curPointx == n-1 && curPointy == n-1) {
                return curDistance;
            }
            
            for (int i = 0; i < 8; i++) {       // for all possible directions
                
                int nextx = dir[i][0] + curPointx;
                int nexty = dir[i][1] + curPointy;
                
                if (checkValidPoint(nextx, nexty, n, grid)) {
                    if (!visited[nextx][nexty]) {         // only proceed for not already visited
                        visited[nextx][nexty] = true;
                        queue.offer(new Point(nextx, nexty, curDistance+1));
                    }
                    
                }
                
            }
        }
        
        return -1;
    }
    
    public boolean checkValidPoint(int x, int y, int max, int [][] grid) {
        return (x >= 0 && x < max && y >= 0 && y < max && grid[x][y] == 0);
    }
    
}
// Author: Shobhit Behl (LC: shobhitbruh)class Solution {
    public class pair{
        int i;
        int j;
        int s;
        
        pair(int i,int j,int s){
            this.i=i;
            this.j=j;
            this.s=s;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        LinkedList<pair> li=new LinkedList<>();
        int ans=Integer.MAX_VALUE;
        int[][] dir={{1,0},{1,1},{0,1},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1}};
        li.addLast(new pair(0,0,1));
        while(li.size()>0){
            int size=li.size();
            while(size-->0){
                pair p=li.removeFirst();
                int x=p.i;
                int y=p.j;
                int st=p.s;
                
                if(x<0||y<0||x>=n||y>=m||vis[x][y]||grid[x][y]!=0){
                    continue;
                }
                if(x==n-1&&y==m-1){
                    ans=Math.min(ans,st);
                    continue;
                }
                vis[x][y]=true;
                for(int[] b:dir){
                    if(x==1&&y==2){
                    }
                    li.addLast(new pair(x+b[0],y+b[1],st+1));
                }
                // vis[x][y]=false;
            }
        }
        
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        
        return ans;
    }
   
}

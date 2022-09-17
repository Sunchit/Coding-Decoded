

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

// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public class Pair implements Comparable<Pair>{
        int x;
        int y;
        int diff;
        
        Pair(int x,int y,int diff){
            this.x=x;
            this.y=y;
            this.diff=diff;
        }
        
        public int compareTo(Pair o){
           return this.diff-o.diff;
        }
    }
    public int minimumEffortPath(int[][] a) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        boolean[][] v=new boolean[a.length][a[0].length];
        pq.add(new Pair(0,0,0));
        while(pq.size()>0){
            int s=pq.size();
            while(s-->0){
                Pair p=pq.remove();
                if(p.x==a.length-1&&p.y==a[0].length-1){
                    return p.diff;
                }
                v[p.x][p.y]=true;
                if(p.x-1>=0&&!v[p.x-1][p.y]){
                    pq.add(new Pair(p.x-1,p.y,(Math.max(p.diff,Math.abs(a[p.x][p.y]-a[p.x-1][p.y])))));
                }
                if(p.x+1<a.length&&!v[p.x+1][p.y]){
                    pq.add(new Pair(p.x+1,p.y,(Math.max(p.diff,Math.abs(a[p.x][p.y]-a[p.x+1][p.y])))));
                }
                if(p.y-1>=0&&!v[p.x][p.y-1]){
                    pq.add(new Pair(p.x,p.y-1,(Math.max(p.diff,Math.abs(a[p.x][p.y]-a[p.x][p.y-1])))));
                }
                if(p.y+1<a[0].length&&!v[p.x][p.y+1]){
                    pq.add(new Pair(p.x,p.y+1,(Math.max(p.diff,Math.abs(a[p.x][p.y]-a[p.x][p.y+1])))));
                }
            }
        }
        
        return -1;
    }
}

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
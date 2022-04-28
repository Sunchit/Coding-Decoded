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
// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public class Pair implements Comparable<Pair>{
        int x;
        int y;
        
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        
        public int compareTo(Pair o){
            if(this.x==o.x){
                return this.y-o.y;
            }
            
            return this.x-o.x;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int min=mat[0].length-1;
        PriorityQueue<Pair> pq = new PriorityQueue();
        int[][] a=new int[mat.length][2];
        for(int i=0;i<mat.length;i++){
            int m=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    m++;
                }else{
                    break;
                }
            }
            min=Math.min(min,m);
            pq.add(new Pair(m,i));
        }
        ArrayList<Integer> p=new ArrayList<>();
        while(k-->0&&pq.size()>0){
            Pair u=pq.remove();
            p.add(u.y);
        }
        return p.stream().mapToInt(i -> i).toArray();
    }
}
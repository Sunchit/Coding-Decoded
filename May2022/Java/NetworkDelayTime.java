// Author: Shobhit Behl (LC: shobhitbruh)
//Dijkstra Algorithm
class Solution {
    public class Node implements Comparable<Node>{
        int d;
        int t;
        
        Node(int d,int t){
            this.d=d;
            this.t=t;
        }
        
        public int compareTo(Node o){
            return this.t-o.t;
        }
        
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Node>[] graph=new ArrayList[n];
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            hs.add(i);
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<times.length;i++){
            int src=times[i][0]-1;
            int dest=times[i][1]-1;
            int time=times[i][2];
            graph[src].add(new Node(dest,time));
        }
        
        PriorityQueue<Node> pq=new PriorityQueue<>();
        int tt=0;
        pq.add(new Node(k-1,0));
        while(pq.size()>0){
            int size=pq.size();
            while(size-->0){
                Node j=pq.remove();
                if(!hs.contains(j.d)){
                    continue;
                }
                hs.remove(j.d);
                tt=Math.max(tt,j.t);
                for(int i=0;i<graph[j.d].size();i++){
                    int p=graph[j.d].get(i).d;
                    int time=graph[j.d].get(i).t;
                    if(hs.contains(p)){
                       pq.add(new Node(p,j.t+time));
                    }
                }
            }
        }
        if(hs.size()>0){
            return -1;
        }
        
        return tt;
    }
}
// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int lastStoneWeight(int[] a) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int v:a){
            pq.add(v);
        }
        
        while(pq.size()>1){
            int x=pq.remove();
            int y=pq.remove();
            if(Math.abs(x-y)>0){
                pq.add(Math.abs(x-y));
            }
        }
        if(pq.size()==0){
            return 0;
        }
        
        return pq.remove();
    }
    
}
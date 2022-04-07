// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun lastStoneWeight(a: IntArray): Int {
       var pq:PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder());
        for(v in a){
            pq.add(v);
        }
        
        while(pq.size>1){
            var x:Int=pq.remove();
            var y:Int=pq.remove();
            if(Math.abs(x-y)>0){
                pq.add(Math.abs(x-y));
            }
        }
        if(pq.size==0){
            return 0;
        }
        
        return pq.remove();   
    }
}
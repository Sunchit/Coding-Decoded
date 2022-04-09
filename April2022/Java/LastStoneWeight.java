

// @saorav21994
// TC : O(nlogn)
// SC : O(n)

// Tried using BFS on normal queue, but failed. So took priority queue.

class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = stones.length-1; i >= 0; i--) {
            queue.offer(stones[i]);
        }
        while (queue.size() > 1) {
            // System.out.println("queue size beg = "+ queue.size());
            int size = queue.size();
            while (size-- > 0) {
                // System.out.println("queue size inner while = "+ size);
                int top1 = queue.poll();
                // System.out.println("top1 = "+ top1);
                int top2 = 0;
                if (size > 0) {
                    top2 = queue.poll();
                    size -= 1;
                }
                // System.out.println("top2 = "+ top2);
                if (top2 != 0) {
                    if (top1 != top2) {
                        queue.offer(Math.abs(top1-top2));
                    }
                }
                else {
                    queue.offer(top1);
                }
            }
        }
        if (queue.size() == 1)
            return queue.poll();
        return 0;
    }
}

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

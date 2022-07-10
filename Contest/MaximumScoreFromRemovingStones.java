// https://leetcode.com/problems/maximum-score-from-removing-stones/
// @author: anuj0503
class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (y - x));
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        
        int result = 0;
        while(!pq.isEmpty()){
            if(pq.size() == 1)
                return result;
            
            int first = pq.poll();
            int second = pq.poll();
            
            first--; second--;
            result++;
            
            if(first != 0)
                pq.offer(first);
            
            if(second != 0)
                pq.offer(second);
        }
        
        return result;
    }
}

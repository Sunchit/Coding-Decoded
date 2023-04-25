Author: Mahesh Reddy BN

Problem Link: https://leetcode.com/problems/last-stone-weight/description/
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i:stones){
            pq.add(i);
        }
        while(pq.size()>1){
            int a = pq.remove();
            int b = pq.remove();
            if(a!=b){
                pq.add(a-b);
            }
        }
        if(pq.size()==0) return 0;
        return pq.remove();
    }
}
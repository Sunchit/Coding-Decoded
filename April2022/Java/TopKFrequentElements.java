// Author: Shobhit Behl (LC: shobhitbruh)
//Using HashMap + Priority Queue
class Solution {
    public class Pair implements Comparable<Pair>{
        int val;
        int freq;
        
        Pair(int val,int freq){
            this.val=val;
            this.freq=freq;
        }
        
        public int compareTo(Pair x){
            return x.freq-this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int el:nums){
            hm.put(el,hm.getOrDefault(el,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int el:hm.keySet()){
            pq.add(new Pair(el,hm.get(el)));
        }
        
        int[] ans=new int[k];
        int i=0;
        while(k-->0){
            ans[i]=pq.remove().val;
            i++;
        }
        
        return ans;
    }
}
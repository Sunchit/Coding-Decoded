// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        for(int i=0;i<k;i++){
            int l=pq.remove();
            l++;
            pq.add(l);
        }
       long m=1;
        while(pq.size()>0){
            m*=pq.remove();
             m=m%1000000007;
        }
        // System.out.println(m);
        m=m%1000000007;
        // System.out.println(m+" -");
        return (int)m;
    }
    
    
}
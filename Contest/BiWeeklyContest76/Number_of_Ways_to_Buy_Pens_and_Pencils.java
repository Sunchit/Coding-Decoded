// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int max=Math.max(cost1,cost2);
        int min=Math.min(cost1,cost2);
        long ans=0;
        long j=(long)Math.floor(total/max);
        for(int i=0;i<=j;i++){
            int k=total;
            k-=(i*max);    
            ans+=(long)Math.floor(k/min)+1;
        }
        
        return ans;
    }
}

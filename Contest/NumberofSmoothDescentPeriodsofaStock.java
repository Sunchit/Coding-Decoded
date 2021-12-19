class Solution {
    // TC :O(n)
    // SC : O(1)
    public long getDescentPeriods(int[] prices) {
        int start=0;
        int end=0;
        long ans = 1;
        for(end=1;end<prices.length;end++){
            if(prices[end] == prices[end-1] - 1){
                ans += end-start+1;
            }else{
                start = end;
                ans += end-start+1;

            }
        }
        return ans;
    }
}
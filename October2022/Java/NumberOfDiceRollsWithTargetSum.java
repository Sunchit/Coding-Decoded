// @saorav21994

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        
        // base case
        if (n*k < target)
            return 0;       // not possible
        if (n > target)
            return 0;       // not possible
        if (n*k == target || target == 1)
            return 1;
        
        int [] dp = new int[target+1];
        
        int max = target;
        if (target > k)
            max = k;        // need to be prefilled with 1
        
        Arrays.fill(dp, 1, max+1, 1);
        
        for (int i = 1; i < n; i++) {
            
            int [] tdp = new int[target+1];
            
            for (int j = 1; j <= k; j++) {
                for (int l = i; l <= target; l++) {
                    
                    if (dp[l] > 0) {        // falls within max limit
                        if (j+l <= target) {
                            tdp[j+l] = (tdp[j+l] + dp[l])%1000000007;
                        }    
                    }
                    
                }
            }
            
            dp = tdp;
        }
            
        return dp[target]%1000000007;
        
        
    }
}

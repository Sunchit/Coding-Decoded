// @saorav21994

class Solution {
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        int n = jobDifficulty.length;
        
        if (n < d)
            return -1;      // not possible
        
        Integer [][] dp = new Integer[n][d+1];
        
        return findMin(jobDifficulty, 0 /*start index*/, d, n, dp);
        
    }
    
    public int findMin(int [] job, int idx, int d, int n, Integer [][] dp) {
        
        if (idx == n && d == 0)     
            return 0;
        
      // d < 0 (OutOfBounds checks)
        if (d < 0)              // not possible, but we need to return large value so that the cal is discarded
            return (int)1e8;
        
        if(n - idx < d)        // not possible, but we need to return large value so that the cal is discarded
             return (int)1e8;
      
        
        if (dp[idx][d] != null)     // memoization
            return dp[idx][d];      
        
        int max = 0;
        int res = Integer.MAX_VALUE;
        
        for (int i = idx; i < n; i++) {
            max = Math.max(max, job[i]);
            res = Math.min(res, max + findMin(job, i+1, d-1, n, dp));
        }
        
        return dp[idx][d] = res;        
        
    }
    
}

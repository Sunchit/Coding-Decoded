
// @saorav21994
// TC:  O(n*k)
// SC : O(k)

// Tried solving using recursion with memoization but TLE. The below solution is implemented with the help of official solution approach specified in leetcode.

public class Solution {
    int M = 1000000007;
    public int kInversePairs(int n, int k) {
    
        int [] dp = new int[k+1];
        
        for (int i = 1; i <= n; i++) {
            
            int [] prevRow = new int[k+1];
            prevRow[0] = 1;     // for k = 0, ans = 1
            for (int j = 1; j <= k; j++)  {
                
                int val = (dp[j] + M - ((j-i >= 0) ? dp[j-i] : 0)) % M;
                prevRow[j] = (prevRow[j-1] + val) % M;
            
            }
            
            dp = prevRow;
            
        }
        
        return ((dp[k] + M - (k > 0 ? dp[k-1] : 0)) % M);
    
    }
    
}

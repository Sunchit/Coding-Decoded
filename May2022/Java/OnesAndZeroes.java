
//@saorav21994
// TC : O(n^m*strs.length)
// SC : O(n^m*strs.length)
// Knapsack approach

class Solution {
    
    Map<Integer, Integer> ones;
    Map<Integer, Integer> zeros;
    
    public int findMaxForm(String[] strs, int m, int n) {
        
        // Knapsack logic -> Max(Consider current, Do not consider current). Add memoization for time reduction.
        
        ones = new HashMap<>();
        zeros = new HashMap<>();
        
        // fill up the maps
        for (int i = 0; i < strs.length; i++) {
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0') {
                    zeros.put(i, zeros.getOrDefault(i, 0) + 1);
                }
                else {
                    ones.put(i, ones.getOrDefault(i, 0) + 1);
                }
            }
        }
        
        int [][][] dp = new int[m+1][n+1][strs.length];
        
        return countLargestSubset(strs, dp, m, n, 0/*start index*/);
    }
    
    public int countLargestSubset(String[] strs, int [][][] dp, int m, int n, int index) {
        
        // Base Case
        if (index == strs.length || m + n == 0) 
            return 0;
        
        // meomoization
        if (dp[m][n][index] > 0) 
            return dp[m][n][index];
        
        int one = ones.get(index) == null ? 0 : ones.get(index);
        int zero = zeros.get(index) == null ? 0 : zeros.get(index);
        
        // consider the current index string
        int take = 0;
        if (m >= zero && n >= one)
            take = 1 + countLargestSubset(strs, dp, m - zero, n - one, index + 1);
        
        // ignore the current index string
        int skip = countLargestSubset(strs, dp, m, n, index + 1);
        
        dp[m][n][index] = Math.max(take, skip);
        
        return dp[m][n][index];
    }
    
    
}

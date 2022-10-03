// https://leetcode.com/problems/decode-ways/

// Recursion - TLE ❌
// TC: O(n^2)
// SC: O(n)	-> auxilary space space
class Solution {
    public int numDecodings(String s) {
        return helper(0, s);
    }

    private int helper(int ind, String s) {
        int n = s.length();
        // base case
        if (ind >= n) {
            return 1;
        }

        int count = 0;
        if (s.charAt(ind) == '0') {
            return count;
        }

        // option 1: 1 digit
        count += helper(ind + 1, s);

        // option 2: 2 digits
        if (ind + 1 < n) {
            if (s.charAt(ind) == '1' || (s.charAt(ind) == '2' && s.charAt(ind + 1) - '0' <= 6)) {
                count += helper(ind + 2, s);
            }
        }

        return count;
    }
}



// Memoization - Accepted ✅
// TC: O(n)
// SC: O(n) + O(n) -> dp array + auxilary stack space
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(0, s, dp);
    }

    private int helper(int ind, String s, int[] dp) {
        int n = s.length();
        // base case
        if (ind >= n) {
            return 1;
        }
        
        if (dp[ind] != -1) {
            return dp[ind];
        }

        int count = 0;
        if (s.charAt(ind) == '0') {
            return dp[ind] = count;
        }

        // option 1: 1 digit
        count += helper(ind + 1, s, dp);

        // option 2: 2 digits
        if (ind + 1 < n) {
            if (s.charAt(ind) == '1' || (s.charAt(ind) == '2' && s.charAt(ind + 1) - '0' <= 6)) {
                count += helper(ind + 2, s, dp);
            }
        }

        return dp[ind] = count;
    }
}



// Tabulation - Accepted ✅
// TC: O(n)
// SC: O(n) -> dp array
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        // base case
        dp[n] = 1;
        
        for (int ind = n - 1; ind >= 0; ind--) {
            int count = 0;
            if (s.charAt(ind) == '0') {
                dp[ind] = count;
                continue;
            }

            // option 1: 1 digit
            count += dp[ind + 1];

            // option 2: 2 digits
            if (ind + 1 < n) {
                if (s.charAt(ind) == '1' || (s.charAt(ind) == '2' && s.charAt(ind + 1) - '0' <= 6)) {
                    count += dp[ind + 2];
                }
            }

            dp[ind] = count;
        }
        
        return dp[0];
    }
}


// Tabulation + Space Optimization - Accepted ✅
// TC: O(n)
// SC: O(1)
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        // base case
        int front1 = 1;
        int front2 = 0;
        
        for (int ind = n - 1; ind >= 0; ind--) {
            int curr = 0;
            if (s.charAt(ind) == '0') {
                front2 = front1;
                front1 = curr;                
                continue;
            }

            // option 1: 1 digit
            curr += front1;

            // option 2: 2 digits
            if (ind + 1 < n) {
                if (s.charAt(ind) == '1' || (s.charAt(ind) == '2' && s.charAt(ind + 1) - '0' <= 6)) {
                    curr += front2;
                }
            }

            front2 = front1;
            front1 = curr;
        }
        
        return front1;
    }
}

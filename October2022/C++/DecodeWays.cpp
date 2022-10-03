// https://leetcode.com/problems/decode-ways/

// Recursion - TLE ❌
// TC: O(n^2)
// SC: O(n)	-> auxilary space space
class Solution {
private:
    int helper(int ind, string& s) {
        int n = s.length();
        // base case
        if (ind >= n) {
            return 1;
        }
        
        int count = 0;
        if (s[ind] == '0') {
            return 0;
        }
        
        // option 1: 1 digit
        count += helper(ind + 1, s);
        
        // option 2: 2 digits
        if (ind + 1 < n) {
            if (s[ind] == '1' || (s[ind] == '2' && s[ind+ 1] - '0' <= 6)) {
                count += helper(ind + 2, s);
            }
        }

        return count;        
    }
    
public:
    int numDecodings(string s) {
        return helper(0, s);
    }
};



// Memoization - Accepted ✅
// TC: O(n)
// SC: O(n) + O(n) -> dp array + auxilary stack space
class Solution {
private:
    int helper(int ind, string& s, vector<int>& dp) {
        int n = s.length();
        // base case
        if (ind >= n) {
            return 1;
        }
        
        if (dp[ind] != -1) {
            return dp[ind];
        }
        
        int count = 0;
        if (s[ind] == '0') {
            return dp[ind] = 0;
        }
        
        // option 1: 1 digit
        count += helper(ind + 1, s, dp);
        
        // option 2: 2 digits
        if (ind + 1 < n) {
            if (s[ind] == '1' || (s[ind] == '2' && s[ind+ 1] - '0' <= 6)) {
                count += helper(ind + 2, s, dp);
            }
        }

        return dp[ind] = count;        
    }
    
public:
    int numDecodings(string s) {
        int n = s.length();
        vector<int> dp(n + 1, -1);
        return helper(0, s, dp);
    }
};



// Tabulation - Accepted ✅
// TC: O(n)
// SC: O(n) -> dp array
class Solution {    
public:
    int numDecodings(string s) {
        int n = s.length();
        vector<int> dp(n + 1, 0);
        
        // base case
        dp[n] = 1;
        
        for (int ind = n - 1; ind >= 0; ind--) {
            int count = 0;
            if (s[ind] == '0') {
                dp[ind] = 0;
                continue;
            }

            // option 1: 1 digit
            count += dp[ind + 1];

            // option 2: 2 digits
            if (ind + 1 < n) {
                if (s[ind] == '1' || (s[ind] == '2' && s[ind+ 1] - '0' <= 6)) {
                    count += dp[ind + 2];
                }
            }

            dp[ind] = count; 
        }
        
        return dp[0];
    }
};


// Tabulation + Space Optimization - Accepted ✅
// TC: O(n)
// SC: O(1)
class Solution {    
public:
    int numDecodings(string s) {
        int n = s.length();
        
        // base case
        int front1 = 1;
        int front2 = 0;
        
        for (int ind = n - 1; ind >= 0; ind--) {
            int curr = 0;
            if (s[ind] == '0') {
                front2 = front1;
                front1 = curr;
                continue;
            }

            // option 1: 1 digit
            curr += front1;

            // option 2: 2 digits
            if (ind + 1 < n) {
                if (s[ind] == '1' || (s[ind] == '2' && s[ind+ 1] - '0' <= 6)) {
                    curr += front2;
                }
            }

            front2 = front1;
            front1 = curr;
        }
        
        return front1;
    }
};

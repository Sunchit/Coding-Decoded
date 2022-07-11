// Recursion - TLE ❌
// TC: O(2^n)
// SC: O(n)
class Solution {    
private:
    int helper(int ind, vector<int>& cost) {
        // base case
        if (ind >= cost.size()) {
            return 0;
        }
        
        int oneStep = cost[ind] + helper(ind + 1, cost);
        int twoStep = cost[ind] + helper(ind + 2, cost);
        
        return min(oneStep, twoStep);
    }
    
public:
    int minCostClimbingStairs(vector<int>& cost) {      
        int zerothStair = helper(0, cost);
        int firstStair = helper(1, cost);
        
        return min(zerothStair, firstStair);
    }        
};


// Memoization - Accepted ✅
// TC: O(n)
// SC: O(n) + O(n) -> stack space + dp array
class Solution {    
private:
    int helper(int ind, vector<int>& cost, vector<int>& dp) {
        // base case
        if (ind >= cost.size()) {
            return 0;
        }
        
        if (dp[ind] != -1) {
            return dp[ind];
        }
        
        int oneStep = cost[ind] + helper(ind + 1, cost, dp);
        int twoStep = cost[ind] + helper(ind + 2, cost, dp);
        
        return dp[ind] = min(oneStep, twoStep);
    }
    
public:
    int minCostClimbingStairs(vector<int>& cost) {  
        int n = cost.size();
        vector<int> dp(n, -1);
        
        int zerothStair = helper(0, cost, dp);
        int firstStair = helper(1, cost, dp);
        
        return min(zerothStair, firstStair);
    }        
};


// Tabulation - Accepted ✅
// TC: O(n)
// SC: O(n) -> dp array
class Solution {        
public:
    int minCostClimbingStairs(vector<int>& cost) {  
        int n = cost.size();
        vector<int> dp(n, 0);
        
        for (int ind = n - 1; ind >= 0; ind--) {
            int oneStep = cost[ind];
            if (ind + 1 < n) {
                oneStep += dp[ind + 1];
            }
            
            int twoStep = cost[ind];
            if (ind + 2 < n) {
                twoStep += dp[ind + 2];
            }
        
            dp[ind] = min(oneStep, twoStep);
        }
        
        int zerothStair = dp[0];
        int firstStair = dp[1];
        
        return min(zerothStair, firstStair);
    }        
};


// Tabulation + Space Optimization - Accepted ✅
// TC: O(n)
// SC: O(1)
class Solution {    
public:
    int minCostClimbingStairs(vector<int>& cost) {  
        int n = cost.size();
        vector<int> dp(2, 0);
        
        for (int ind = n - 1; ind >= 0; ind--) {
            int oneStep = cost[ind];
            if (ind + 1 < n) {
                oneStep += dp[(ind + 1) % 2];
            }
            
            int twoStep = cost[ind];
            if (ind + 2 < n) {
                twoStep += dp[(ind + 2) % 2];
            }
        
            dp[ind % 2] = min(oneStep, twoStep);
        }
        
        int zerothStair = dp[0];
        int firstStair = dp[1];
        
        return min(zerothStair, firstStair);
    }
};

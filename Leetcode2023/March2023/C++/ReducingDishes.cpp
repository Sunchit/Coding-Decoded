// https://leetcode.com/problems/reducing-dishes/
class Solution {
private: 
    int helper(int idx, int t, vector<int>& satisfaction, vector<vector<int>>& dp) {
        if (idx >= satisfaction.size()) {
            return 0;
        }
        
        if (dp[idx][t] != -1) {
            return dp[idx][t];
        }
                
        // take
        int take = (satisfaction[idx] * t) + helper(idx + 1, t + 1, satisfaction, dp);
                
        // not take
        int notTake = helper(idx + 1, t, satisfaction, dp);
                
        return dp[idx][t] = max(take, notTake);
    }

public:
    // TC: O(nlogn) + O(n^2)
    // SC: O(n^2)
    int maxSatisfaction(vector<int>& satisfaction) {
        int n = satisfaction.size();
        
        sort(satisfaction.begin(), satisfaction.end());                  
        vector<vector<int>> dp(n, vector<int>(n+1, -1));
        
        return helper(0, 1, satisfaction, dp);
    }
};

// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

// Dynamic Programming - Tabulation ✅
class Solution {
public:
    // TC: O(n * m)
    // SC: O(n * m) -> dp array
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int m = nums2.size();
        
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        int ans = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return ans;
    }
};


// Dynamic Programming - Tabulation + Space Optimization ✅
class Solution {
public:
    // TC: O(n * m)
    // SC: O(2 * m)
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int m = nums2.size();
        
        vector<int> prev(m + 1, 0);
        vector<int> curr(m + 1, 0);
        int ans = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    curr[j] = 1 + prev[j - 1];
                    ans = max(ans, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr;
        }
        
        return ans;
    }
};

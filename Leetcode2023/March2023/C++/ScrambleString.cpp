// https://leetcode.com/problems/scramble-string/
class Solution {
private:
    bool helper(string s1, string s2, unordered_map<string, bool>& dp) {
        // base case
        if (s1 == s2) {
            return true;
        }
        if (s1.length() <= 1 || s2.length() <= 1) {
            return false;
        }
        
        string key = s1 + "-" + s2;
        if (dp.count(key)) {
            return dp[key];
        }
        
        int n = s1.length();
        bool flag = false;
        
        for (int i = 1; i <= n - 1; i++) {
            bool swap = helper(s1.substr(0, i), s2.substr(n - i), dp) && helper(s1.substr(i), s2.substr(0, n - i), dp);
            if (swap) {
                flag = true;
                break;
            }
            
            bool notSwap = helper(s1.substr(0, i), s2.substr(0, i), dp) && helper(s1.substr(i), s2.substr(i), dp);
            if (notSwap) {
                flag = true;
                break;
            }
        }
                
        return dp[key] = flag;
    }
    
public:
    bool isScramble(string s1, string s2) {
        unordered_map<string, bool> dp;
        return helper(s1, s2, dp);
    }
};

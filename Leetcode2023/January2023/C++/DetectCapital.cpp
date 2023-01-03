// https://leetcode.com/problems/detect-capital/
class Solution {
public:
    // TC: O(n)
    // SC: O(1)
    bool detectCapitalUse(string word) {
        int n = word.length();
        int capsCount = 0;
        int lastCapsPosition = -1;
        
        for (int i = 0; i < n; i++) {
            char c = word[i];
            if (c - 'A' >= 0 && c - 'A' < 26) {
                capsCount++;
                lastCapsPosition = i;
            }
        }
        
        if (capsCount == n) {   // case 1
            return true;
        } else if (capsCount == 0 && lastCapsPosition == -1) {   // case 2
            return true;
        } else if (capsCount == 1 && lastCapsPosition == 0) {  // case 3
            return true;
        }
        
        return false;
    }
};

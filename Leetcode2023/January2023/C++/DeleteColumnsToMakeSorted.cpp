// https://leetcode.com/problems/delete-columns-to-make-sorted/
class Solution {
public:
    // TC: O(n * m)
    // SC: O(1)
    int minDeletionSize(vector<string>& strs) {
        int n = strs.size();
        int m = strs[0].length();
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j][i] < strs[j - 1][i]) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
};

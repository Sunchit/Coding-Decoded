class Solution {
public:
    // TC: O(numRows^2)
    // SC: O(2 * numRows)
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;
        vector<int> curr, prev;
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.push_back(1);
                } else {
                    curr.push_back(prev[j - 1] + prev[j]);
                }
            }
            ans.push_back(curr);
            prev = curr;
            curr.clear();
        }
        
        return ans;
    }
};

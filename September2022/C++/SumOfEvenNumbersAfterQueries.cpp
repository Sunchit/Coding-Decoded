// https://leetcode.com/problems/sum-of-even-numbers-after-queries/
class Solution {
public:
    // TC: O(nums.length + queries.length)
    // SC: O(1)
    vector<int> sumEvenAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        int sum = 0;
        for (auto it : nums) {
            if (it % 2 == 0) {
                sum += it;
            }
        }
        
        vector<int> ans;
        for (auto query : queries) {
            int val = query[0];
            int index = query[1];
            
            if (nums[index] % 2 == 0) {
                sum -= nums[index];
            }
            nums[index] += val;
            if (nums[index] % 2 == 0) {
                sum += nums[index];
            }
            
            ans.push_back(sum);
        }
        
        return ans;
    }
};

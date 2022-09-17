class Solution {
private:
    TreeNode* helper(int start, int end, vector<int>& nums) {
        // base case
        if (start > end) {
            return NULL;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode* root = new TreeNode(nums[mid]);
        root->left = helper(start, mid - 1, nums);
        root->right = helper(mid + 1, end, nums);
        return root;
    }
    
public:
    // TC: O(n)
    // SC: O(logn)
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return helper(0, nums.size() - 1, nums);
    }
};

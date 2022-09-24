// https://leetcode.com/problems/path-sum-ii
class Solution {
private:    
    void helper(TreeNode* root, int target, vector<vector<int>>& ans, vector<int>& curr) {
        if(root == NULL) {
            return;
        }
        
        // leaf node
        if(root->left == NULL && root->right == NULL) {
            if (root->val - target == 0) {
                curr.push_back(root->val);
                ans.push_back(curr);
                curr.pop_back();
            }
            return;
        }
        
        curr.push_back(root->val);        
        
        // left subtree
        helper(root->left, target - root->val, ans, curr);
        
        // right subtree
        helper(root->right, target - root->val, ans, curr);        
        
        curr.pop_back();
    }

public:
    // TC: O(n)
    // SC: O(logn)
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> ans;
        vector<int> curr;
        
        // edge case
        if (root == NULL) {
            return ans;
        }        
        
        helper(root, targetSum, ans, curr);
        return ans;
    }
};

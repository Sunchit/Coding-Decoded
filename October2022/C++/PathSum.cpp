// https://leetcode.com/problems/path-sum/
class Solution {
private:
    bool helper(TreeNode* root, int target) {
        if (root == NULL) {
            return false;
        }
        
        if (root->left == NULL && root->right == NULL) {
            if (target - root->val == 0) {
                return true;
            }
            return false;
        }
        bool left = helper(root->left, target - root->val);
        bool right = false;
        if (!left) {
            right = helper(root->right, target - root->val);
        }
        
        return left || right;
    }
    
public:
    // TC: O(n)
    // SC: O(logn)
    bool hasPathSum(TreeNode* root, int targetSum) {
        return helper(root, targetSum);
    }
};

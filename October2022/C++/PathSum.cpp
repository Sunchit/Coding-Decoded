// https://leetcode.com/problems/path-sum/
class Solution {    
public:
    // TC: O(n)
    // SC: O(logn)
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (root == NULL) {
            return false;
        }
        
        if (root->left == NULL && root->right == NULL) {    // leaf node
            return target - root->val == 0;
        }
        
        bool left = hasPathSum(root->left, target - root->val);
        bool right = false;
        if (!left) {
            right = hasPathSum(root->right, target - root->val);
        }
        
        return left || right;
    }
};

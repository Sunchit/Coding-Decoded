// https://leetcode.com/problems/binary-tree-pruning/
class Solution {
private:
    bool helper(TreeNode* root) {
        if (root == NULL) {
            return false;
        }
        
        // Check left subtree contains a 1
        bool left = helper(root->left);
        // Check right subtree contains a 1
        bool right = helper(root->right);

        // If not then prune the tree
        if (!left) {
            root->left = NULL;
        }
        if (!right) {
            root->right = NULL;
        }
        
        // Return true if the current node, left or right subtree contains a 1
        return root->val == 1 || left || right;
    }
    
public:
    // TC: O(n)
    // SC: O(logn)
    TreeNode* pruneTree(TreeNode* root) {
        return helper(root) ? root : NULL;
    }
};

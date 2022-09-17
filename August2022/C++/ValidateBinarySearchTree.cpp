class Solution {
private:
    bool helper(TreeNode* root, long min, long max) {
        if (root == NULL) {
            return true;
        }    
        
        return root->val > min && root->val < max && helper(root->left, min, root->val) && helper(root->right, root->val, max);
    }
    
public:
    // TC: O(n)
    // SC: O(logn)
    bool isValidBST(TreeNode* root) {
        long min = LONG_MIN;
        long max = LONG_MAX;
        return helper(root, min, max);
    }
};
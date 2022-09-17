class Solution {
private:
    TreeNode* prev = NULL;
    
public:
    // TC: O(n)
    // SC: O(n)
    void flatten(TreeNode* root) {
        if (root == NULL) {
            return;
        }
        
        flatten(root->right);
        flatten(root->left);
        
        root->right = prev;
        root->left = NULL;
        prev = root;
    }
};

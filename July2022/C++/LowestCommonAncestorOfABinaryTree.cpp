class Solution {
public:
    // TC: O(n)
    // SC: O(n)
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL) {
            return NULL;
        }
        if (root == p || root == q) {   // we have found one of the required node
            return root;
        }
        
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        
        if (left == NULL) {
            return right;
        } else if (right == NULL) {
            return left;
        } else {    // both left and right are not null, we found our result
            return root;
        }
    }
};

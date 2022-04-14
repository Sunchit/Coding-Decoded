/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* searchBST(TreeNode* root, int val) {
        
        if(root == NULL)
            return root;
        
        if(root -> val == val)
            return root;
        
        TreeNode* res = NULL;
        if(root -> val > val)
            res = searchBST(root -> left, val);
        else
           res = searchBST(root -> right, val);
        
        return res;
    }
};

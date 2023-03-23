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
    private:
    bool solve(TreeNode* a, TreeNode* b)
    {
        if(!a and !b) return true;
        if(!a or !b) return false;
        
        return (a->val==b->val and solve(a->left, b->right) and solve(a->right, b->left));
    }
public:
    bool isSymmetric(TreeNode* root) {
        
        if(!root) return true;
        
        return solve(root->left, root->right);
    }
};

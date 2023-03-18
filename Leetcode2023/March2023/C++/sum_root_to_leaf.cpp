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
    int sumNumbers(TreeNode* root) {
        if(!root) return 0;
        if(!root->left && !root->right) return root->val;

        return calST(root->left,root->val*10) +calST(root->right,root->val*10);
    }

    int calST(TreeNode* node, long int parent)
    {
        if(!node) return 0;
        int left = calST(node->left,(node->val+parent)*10);  
        int right = calST(node->right,(node->val+parent)*10);
        if(left ==0 && right ==0) return parent+node->val;
        
        return left+right;
    }
};
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
    int rangeSumBST(TreeNode* root, int low, int high) {
        int res=0;
        stack<TreeNode* > stack;
        stack.push(root);
        while(stack.size())
        {
            TreeNode* root=stack.top();
            stack.pop();
            if(root->right) stack.push(root->right);
            if(root->left) stack.push(root->left);
            if(root->val>=low && root->val<=high) res+=root->val;
                
        }
        return res;
    }
};
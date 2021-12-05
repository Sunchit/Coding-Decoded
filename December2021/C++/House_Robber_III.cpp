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
    int rob(TreeNode* root) {
       vector<int> res=dfs(root);
        return max(res[0],res[1]);
    }
    
    vector<int> dfs(TreeNode* root)
    {
        if(!root) return {0,0};
        vector<int> left=dfs(root->left);
        vector<int> right=dfs(root->right);
        int incurr=root->val+left[1]+right[1];
        int notcurr=max({left[0]+right[0],left[1]+right[1],left[0]+right[1],left[1]+right[0]});
        return {incurr,notcurr};
    }
};
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
    int res=0;
    // vector<int> left;
    // vector<int> right;
public:
    int maxAncestorDiff(TreeNode* root) {
      dfs(root);
     return res;
        
    }
    vector<int> dfs(TreeNode* root)
    {
        if(!root)
            return {INT_MAX,INT_MIN};
        vector<int> left =dfs(root->left);
        vector<int> right=dfs(root->right);
      
        int new_min=min(left[0],right[0]),new_max=max(left[1],right[1]);
        if(new_min==INT_MAX) new_min=root->val;
        if(new_max==INT_MIN) new_max=root->val;
        res=max({res,abs(root->val-new_min),abs(root->val-new_max)});
        return {min(root->val,new_min),max(root->val,new_max)};
    }
};
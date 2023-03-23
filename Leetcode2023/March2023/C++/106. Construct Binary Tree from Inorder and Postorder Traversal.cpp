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
    TreeNode* solve(vector<int> &in, vector<int> &pos, unordered_map<int,int> &m, int st,
                   int end, int &rootind)
    {
        if(st>end) return NULL;
        
        int ind = m[pos[rootind]];
        TreeNode* root = new TreeNode(pos[rootind--]);
        root->right = solve(in, pos, m, ind+1, end, rootind);
        root->left = solve(in, pos, m, st, ind-1, rootind);
        
        return root;
    }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        
        unordered_map<int,int> m;
        int n = inorder.size();
        for(int i=0;i<n;i++) m[inorder[i]] = i;
        int x = n-1;
        return solve(inorder, postorder, m, 0, n-1, x);
    }
};

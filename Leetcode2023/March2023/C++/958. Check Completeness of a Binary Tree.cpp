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
    bool isCompleteTree(TreeNode* root) {
        
        if(!root) return true;
        bool f=false;
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty())
        {
            auto x = q.front(); q.pop();
            
            if(x==NULL) f = true;
            else 
            {
                if(f) return false;
                q.push(x->left);
                q.push(x->right);
            }
        }
        return true;
    }
};

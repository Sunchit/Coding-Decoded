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
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        vector<vector<int>> ans;
        if(!root) return ans;
        
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty())
        {
            vector<int> level;  // Vector for storing nodes present in same level
            int n = q.size();
            
            for(int i=0;i<n;i++)    // Going to the all nodes present in same level 
            {
                auto node = q.front(); q.pop();
                level.push_back(node->val);     
                
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            ans.push_back(level); // Adding all the node of same level 
        }
        return ans;
    }
};

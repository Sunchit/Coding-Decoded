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
    int widthOfBinaryTree(TreeNode* root) {
        
        if(!root) return 0;
        queue<pair<TreeNode*, unsigned long long int>> q;
        q.push({root, 1});
        unsigned long long int ans = 0;
        
        while(!q.empty())
        {
            int size = q.size();
            unsigned long long int l = q.front().second, r = l;
            while(size--)
            {
                auto node = q.front().first; 
                r = q.front().second; q.pop();
                
                if(node->left) q.push({node->left, (unsigned long long int)(2LL*r)});
                if(node->right) q.push({node->right, (long long int)(2LL*r+1)});
            }
            if(ans<r-l+1) ans = r-l+1;
        }
        return ans;
    }
};

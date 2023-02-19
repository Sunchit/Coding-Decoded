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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if(!root) return {};
        queue<TreeNode*> q;
        vector<vector<int>> res;
        // vector<int> temp;
        q.push(root);
        int size,level=0;
        while(q.size())
        {
            size=q.size();
            vector<int> temp(size);
            for(int i=0;i<size;i++)
            {
                // temp.push_back(q.front()->val);
                if(level%2) temp[size-i-1]=q.front()->val;
                else temp[i]=q.front()->val;
                if(q.front()->left) q.push(q.front()->left);
                if(q.front()->right) q.push(q.front()->right);
                q.pop(); 
            }
            // if(level%2) reverse(begin(temp),end(temp));
            res.push_back(temp);
            level++;
        }
        return res;
    }   
};
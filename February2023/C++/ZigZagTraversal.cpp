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
        deque<TreeNode*> q;
        vector<vector<int>> res;
        vector<int> temp;
        q.push_back(root);
        int size,level=0;
        TreeNode* curr=NULL;
        while(!q.empty())
        {
            size= q.size();
            for(int i=0;i<size;i++)
            {
                if(level%2)
                {
                    curr=q.back();
                    q.pop_back();
                    temp.push_back(curr->val);
                    if(curr->right) q.push_front(curr->right);
                    if(curr->left) q.push_front(curr->left);
                }
                else
                {
                    curr=q.front();
                    q.pop_front();
                    temp.push_back(curr->val);
                    if(curr->left) q.push_back(curr->left);
                    if(curr->right) q.push_back(curr->right);
                }
            }
            res.push_back(temp);
            temp.clear();
            level++;
        }
        return res;
    }   
};
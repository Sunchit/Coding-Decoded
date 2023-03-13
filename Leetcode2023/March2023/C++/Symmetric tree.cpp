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
    bool isSymmetric(TreeNode* root) {
        queue<TreeNode*> q;
        vector<TreeNode*> pal;
        q.push(root);
        int size;
        while(q.size())
        {
            size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode* temp= q.front();
                q.pop();
                pal.push_back(temp->left);
                if(temp->left)  q.push(temp->left);
                pal.push_back(temp->right);
                if(temp->right) q.push(temp->right); 
            }
            if(notPal(pal)) return false;            
            pal.clear();
        }
        return true;
    }

    bool notPal(vector<TreeNode*>& pal)
    {
        int l=0,r=pal.size()-1;
        while(l<r)
        {
            if((pal[l] && pal[r] && pal[l]->val!=pal[r]->val)
               || (!pal[l] && pal[r]) || (pal[l] && !pal[r])
            ) return true;
            l++;
            r--;
        }
        return false;
    }
};
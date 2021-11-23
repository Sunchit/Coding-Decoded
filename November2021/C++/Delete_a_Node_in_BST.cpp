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
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(!root) return NULL;
        if(root->val<key)
            root->right= deleteNode(root->right,key);
        else if(root->val>key)
            root->left= deleteNode(root->left,key);
        else
        {
            if(!root->right)
                return root->left;
            else if(!root->left)
                return root->right;
            
            TreeNode* minnode=findmind(root->right);
            root->val=minnode->val;
            root->right=deleteNode(root->right,minnode->val);
        }
            return root;
    
    }
    
    TreeNode* findmind(TreeNode* node)
    {
        
        while((node->left))
            node=node->left;
        return node;
    }
};
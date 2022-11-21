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
private:
    int count(TreeNode*root){
           if(root==NULL){
            return 0;
        }
        if(root->left==NULL && root->right==NULL){
            return 1;
        }
        int lh = 1+ findHeightL(root->left);
        int rh = 1+ findHeightR(root->right);
        
        if(lh==rh){
            // cout<<lh<<" "<<"\n";
            return (1<<lh)-1;
        }
 
        return 1 + count(root->left) + count(root->right);
    }
    int findHeightR(TreeNode*root){
        if(root==NULL){
            return 0;
        }
        return 1 + findHeightR(root->right);
    }
     int findHeightL(TreeNode*root){
        if(root==NULL){
            return 0;
        }
        return 1 + findHeightL(root->left);
    }
public:
    int countNodes(TreeNode* root) {
        return count(root);
    }
};
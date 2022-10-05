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


// https://leetcode.com/problems/add-one-row-to-tree/
// TC O(n)
// SC O(height of Tree)

class Solution {
private:
    void insertNewRow(TreeNode*root,int val,int depth,int currDepth){
        
        if(root==NULL){
            return;
        }
        // Adding nodes to current depth
        if(currDepth == (depth-1)){
            TreeNode*currRight = root->right;
            TreeNode*currLeft = root->left;
            root->right = new TreeNode(val);
            root->left = new TreeNode(val);
            root->right->right = currRight;
            root->left->left = currLeft;
            return;
        }
        
        // Searching for required depth
        insertNewRow(root->left,val,depth,currDepth+1);
         insertNewRow(root->right,val,depth,currDepth+1);
    }
public:
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        
        //  Handling Edge Case
        if(depth==1){
            TreeNode* newRoot = new TreeNode(val);
            newRoot->left = root;
            return newRoot;
        }
        // Function to add Row at given depth
        insertNewRow(root,val,depth,1);
        
        return root;
    }
};
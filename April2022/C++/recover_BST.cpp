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
//Problem Link : https://leetcode.com/problems/recover-binary-search-tree/
class Solution {
    TreeNode* prev;
    TreeNode* first;
    TreeNode* mid;
    TreeNode* last;
public:
    void inorderT(TreeNode* root){
        
        if(root == NULL) return;
        
        inorderT(root -> left);
        
        if(prev != NULL && prev -> val > root -> val){
            
            if(first == NULL){
                
                first = prev;
                mid = root;
            }
            else{
                last = root;
              
            }
        }
        prev = root;
        inorderT(root -> right);
        
    }
    void recoverTree(TreeNode* root) {
        first = mid = last = NULL;
        prev = new TreeNode(INT_MIN);
        inorderT(root);
        if(last) swap(first -> val, last -> val);
        else
            swap(first -> val, mid -> val);
    }
};

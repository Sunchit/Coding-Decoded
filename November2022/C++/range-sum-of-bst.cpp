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
    void findRangeSum(int &totalSum, int low, int high, TreeNode*root){
        
        if(root==NULL){
            return;
        }
        
        if(root->val<low){
            
          findRangeSum(totalSum,low,high,root->right);
        }
        
          else if(root->val>high){
            
          findRangeSum(totalSum,low,high,root->left);
        }
        
        else{
        totalSum += root->val;
        
       findRangeSum(totalSum,low,high,root->left);
           findRangeSum(totalSum,low,high,root->right);
            
        }
    }
public:
    
    int rangeSumBST(TreeNode* root, int low, int high) {
        
        int totalSum = 0;
        
        findRangeSum(totalSum,low, high, root);
        
        return totalSum;
    }
};
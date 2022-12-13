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
    
    int findMaxPathSum(TreeNode* root, int &maxSum){
        
        if(root == NULL){
            
            return 0;
        }
        
       
        int node = root->val;
        
        int leftMaxSum  = max(0, findMaxPathSum(root->left, maxSum));
        int rightMaxSum = max(0, findMaxPathSum(root->right, maxSum));
        
        maxSum = max( maxSum, leftMaxSum + rightMaxSum + node);
  
        return max(leftMaxSum + node, rightMaxSum + node);
    }
    
public:
    int maxPathSum(TreeNode* root) {
        
        int maxSum = INT_MIN;
        
        findMaxPathSum(root, maxSum);
        
        return maxSum;
    }
};
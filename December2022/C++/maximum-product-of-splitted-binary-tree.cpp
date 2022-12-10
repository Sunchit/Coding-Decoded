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
    
    long long findMaxSum( TreeNode*root, long long &ans, long long &totalSum){
        
        if(root == NULL){
            
            return 0;
        }

        long long currSum = findMaxSum(root->left, ans, totalSum) + findMaxSum(root->right, ans, totalSum) + root->val;
        
        ans = max(ans, currSum*(totalSum-currSum));
        
        return currSum;
    }
public:
    int maxProduct(TreeNode* root) {
        
        long long totalSum = 0;
        long long ans = 0;
        long long mod = 1e9 + 7;
        totalSum  = findMaxSum(root, ans, totalSum);
        
        findMaxSum(root, ans, totalSum);
        
        return ans%mod;
    }
};
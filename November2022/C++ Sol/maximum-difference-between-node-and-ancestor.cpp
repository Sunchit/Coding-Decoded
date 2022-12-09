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
    
    pair<int,int> findMaxDiff(TreeNode* root, int &maxDiff){
        
        if(root->left==NULL && root->right == NULL){
            return {root->val, root->val};
        }
        
        int node = root->val;
        
         pair<int,int>leftMax = {node,node};
         pair<int,int>rightMax = {node,node};
        
        if(root->left){
            
            leftMax = findMaxDiff(root->left, maxDiff);
        }
        if(root->right){
            
            rightMax = findMaxDiff(root->right, maxDiff);
            
        }
        
        maxDiff = max({maxDiff,abs(leftMax.first-node),abs(leftMax.second-node),abs(rightMax.second-node),abs(rightMax.first-node)});
        
        
        return {max({node,leftMax.first,rightMax.first}), min({node,leftMax.second,rightMax.second})};
    }
public:
    int maxAncestorDiff(TreeNode* root) {
        
        int maxDiff = 0;
        
        findMaxDiff(root, maxDiff);
        
        return maxDiff;
    }
};
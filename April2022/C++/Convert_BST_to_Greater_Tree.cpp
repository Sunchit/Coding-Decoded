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
 Problem Link - https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
class Solution {
public:
    int greaterNodeSum = 0;
    TreeNode* convertBST(TreeNode* root) {
        
        if(root == NULL)
            return NULL;
        convertBST(root -> right);
        greaterNodeSum += root -> val;
        root -> val = greaterNodeSum;
        convertBST(root -> left);
        return root;
    }
};

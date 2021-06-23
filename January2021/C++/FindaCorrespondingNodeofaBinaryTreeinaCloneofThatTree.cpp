/**
 * Author: Simranjeet Randhawa
 * Description: Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * Let N be the number of nodes and d is the maximum depth.
 * Time Complexity: O(N)
 * Space Complexity: O(d) 
 * */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution
{

public:
    TreeNode *getTargetCopy(TreeNode *original, TreeNode *cloned, TreeNode *target)
    {

        if (original == NULL)
            return NULL;

        if (original == target)
        {
            return cloned;
        }

        TreeNode *left = getTargetCopy(original->left, cloned->left, target);
        if (left != NULL)
            return left;
        TreeNode *right = getTargetCopy(original->right, cloned->right, target);
        return right;
    }
};
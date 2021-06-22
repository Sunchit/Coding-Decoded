/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

//TC:O(N) | SC:O(d) where N is number of nodes and d is the maximum depth.
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
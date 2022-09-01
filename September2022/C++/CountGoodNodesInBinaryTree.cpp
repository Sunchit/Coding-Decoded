class Solution {
private:
    int helper(TreeNode* root, int currMax) {
        if (root == NULL) {
            return 0;
        }
        int count = 0;
        if (root->val >= currMax) {
            count += 1;
            currMax = root->val;
        }
        count += helper(root->left, currMax);
        count += helper(root->right, currMax);
        return count;
    }
    
public:
    // TC: O(n)
    // SC: O(h)
    int goodNodes(TreeNode* root) {
        return helper(root, root->val);
    }
};

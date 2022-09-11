// https://leetcode.com/problems/binary-tree-inorder-traversal/
class Solution {
public:
    // TC: O(n)
    // SC: O(logn)
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> inorder;
        stack<TreeNode*> stack;
        TreeNode* node = root;
        
        while (true) {
            if (node != NULL) {
                stack.push(node);
                node = node->left;
            } else {
                if (stack.empty()) {
                    break;
                }
                node = stack.top();
                stack.pop();
                inorder.push_back(node->val);
                node = node->right;
            }
        }
        
        return inorder;
    }
};

// https://leetcode.com/problems/construct-string-from-binary-tree/
class Solution {
private:
    void preorder(TreeNode* root, string& str) {
        str += to_string(root->val);
        if (root->left != NULL) {
            str += "(";
            preorder(root->left, str);
            str += ")";
        }
        if (root->right != NULL) {
            if (root->left == NULL) {
                str += "()";
            }
            str += "(";
            preorder(root->right, str);
            str += ")";            
        }
    }
    
public:
    // TC: O(n)
    // SC: O(logn)
    string tree2str(TreeNode* root) {
        string str = "";
        preorder(root, str);
        return str;
    }
};

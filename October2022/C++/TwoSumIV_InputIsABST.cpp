// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
class Solution {
private:
    bool helper(TreeNode* root, int k, unordered_set<int>& set) {
        if (root == NULL) {
            return false;
        }    
        
        if (set.count(k - root->val)) {
            return true;
        }        
        set.insert(root->val);

        bool left = helper(root->left, k, set);
        bool right = false;
        if (!left) {
            right = helper(root->right, k, set);
        }
        
        return left || right;
    }
    
public:
    // TC: O(n)
    // SC: O(n)
    bool findTarget(TreeNode* root, int k) {
        unordered_set<int> set;
        return helper(root, k, set);
    }
};

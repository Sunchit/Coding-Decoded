class Solution {
private:
    TreeNode* helper(vector<int>& preorder, int preStart, int preEnd, vector<int>& inorder, int inStart, int inEnd, map<int, int> map) {
        // base case
        if (preStart > preEnd || inStart > inEnd) {
            return NULL;
        }
        
        TreeNode* root = new TreeNode(preorder[preStart]);
        
        int inRoot = map[root->val];
        int numsLeft = inRoot - inStart;
        
        root->left = helper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        
        root->right = helper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        
        return root;
    }
        
public:
    // TC: O(n)
    // SC: O(n)
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        map<int, int> map;
        
        for (int i = 0; i < inorder.size(); i++) {
            map[inorder[i]] = i;
        }
        
        TreeNode* root = helper(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, map);
        
        return root;
    }
};

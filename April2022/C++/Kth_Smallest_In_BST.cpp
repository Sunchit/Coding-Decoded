class Solution {
public:
    int count,n;
    int kthSmallest(TreeNode* root, int k) {
        n=k;
        count=0;
        return bst(root)->val;
    }
    TreeNode* bst(TreeNode* root)
    {
        if(!root) return NULL;
        TreeNode* node=bst(root->left);
        if(node ) return node;
        ++count;
        if(count==n) return root;
        return bst(root->right);
    }
};
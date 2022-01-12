class Solution {
public:
    int sumRootToLeaf(TreeNode* root, int num=0) {
       if(!root)
            return 0;
        num=2*num+root->val;
        if(!root->left&&!root->right)
            return num;
        return sumRootToLeaf(root->left,num)+sumRootToLeaf(root->right,num);
    }
};

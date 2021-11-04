class Solution {
    int res=0;
public:
    int sumOfLeftLeaves(TreeNode* root) {
        
        sumofLeft(root,-1);
        return res;
    }
    
    void sumofLeft(TreeNode* child,int dir)
    {
        if(!child) return ;
        
        if(!child->left && !child->right)
        {
            if(dir==0)
                res+=child->val;
            return ;
        }
        
        sumofLeft(child->left,0);
        sumofLeft(child->right,1);
    }
};
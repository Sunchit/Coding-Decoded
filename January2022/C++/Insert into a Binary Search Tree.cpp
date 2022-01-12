
//Recursion approach:

class Solution {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if(root == nullptr)return new TreeNode(val);
        TreeNode* curr = root;
        
        if(val >= curr->val){
           if(curr->right){
               insertIntoBST(curr->right,val);
           } 
            else{
                TreeNode* r  = new TreeNode(val);
                curr->right = r;
                // break;
            }
        }
        else{
            if(curr->left){
               insertIntoBST(curr->left,val);
           } 
            else{
                TreeNode* r  = new TreeNode(val);
                curr->left = r;
                // break;
            }
        }
        return root;
    }
};


// Without Recursion
class Solution {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if(root == nullptr)return new TreeNode(val);
        TreeNode* curr = root;
        while(curr){
            if(val >= curr->val){
                if(curr->right){
                    curr = curr->right;
                }
                else{
                    curr->right = new TreeNode(val);
                    break;
                }
            }
            else{
                // when val is lesser than root value
                if(curr->left){
                    curr = curr->left;
                }
                else{
                    curr->left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
};

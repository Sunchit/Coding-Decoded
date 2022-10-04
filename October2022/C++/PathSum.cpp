
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */


// https://leetcode.com/problems/path-sum/ 
// TC O(n)
// SC O(n)  (Recursion stack space for left skewed or right skewed tree)

class Solution {
private:
    bool find(TreeNode*root,int target){
        if(root==NULL){
            return false;
        }
        if(root->left==NULL && root->right==NULL){
            target = target - root->val;
            if(target==0){
                return true;
            }
            else{
                return false;
            }
        }
        target = target - root->val;
        bool t1 = find(root->left,target);
         bool t2 = find(root->right,target);
    if(t1==true || t2==true){
        return true;
    }
         return false;
    }
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        return find(root,targetSum);
    }
};

// https://leetcode.com/problems/path-sum/
class Solution {    
public:
    // TC: O(n)
    // SC: O(logn)
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (root == NULL) {
            return false;
        }
        
        if (root->left == NULL && root->right == NULL) {    // leaf node
            return target - root->val == 0;
        }
        
        bool left = hasPathSum(root->left, target - root->val);
        bool right = false;
        if (!left) {
            right = hasPathSum(root->right, target - root->val);
        }
        
        return left || right;
    }
};

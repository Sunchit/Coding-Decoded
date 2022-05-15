/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 Problem Link :- https://leetcode.com/problems/increasing-order-search-tree/
 */
class Solution {
public:
    TreeNode* increasingBST(TreeNode* root) {
      stack<TreeNode*> st;
        TreeNode* prev = NULL;
        TreeNode* head = NULL;
        TreeNode* curr = root;
        while(!st.empty() || curr!=NULL){
            while(curr != NULL){
                st.push(curr);
                curr = curr -> left;
            }
            TreeNode* top = st.top();
             st.pop();
            top -> left = NULL;
            
            if(head == NULL)
                head = top;
            
            if(prev != NULL){
                prev -> right = top;
            }
            prev = top;
            curr = top -> right;
           
        }
        
        return head;
    }
};

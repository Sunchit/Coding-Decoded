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
 */
class Solution {
    int cnt = 0;
public:
    int kthSmallest(TreeNode* root, int k) {
        
      stack<TreeNode*> st;
        
        while(1){
          
            while(root!=NULL){
                st.push(root);
                 root = root -> left;        
            }
         root = st.top();
            st.pop();
            cnt++;
            if(cnt == k) return root -> val;
            root=root->right;
            
          
        }
    }
};

// Problem Link : https://leetcode.com/problems/binary-search-tree-iterator/
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
class BSTIterator {
public:
    TreeNode* curr;
    stack<TreeNode*> st;
    
    BSTIterator(TreeNode* root) {
        curr = root;
    }
    
    int next() {
        while(curr != NULL){
            st.push(curr);
            curr = curr -> left; 
        }
        TreeNode* tp = st.top();st.pop();
        curr = tp -> right;
        return tp -> val;
    }
    
    bool hasNext() {
       return st.size() || curr !=NULL ; 
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */

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
    //   TC -> O(n)
    //   SC -> O(n)
public:
    unordered_map<int,int>m;
    int ind = 0;
    TreeNode* f(vector<int>& preorder, int left, int right)
    {
        if(left>right) return NULL;
        
        int value = preorder[ind++]; // Root node value 
        TreeNode* root = new TreeNode(value); // Created tree node for root
        
        int mid = m[value]; // Ind of root node inn inorder vector
        
        root->left = f(preorder,left,mid-1);  // Passing all left side of that index to left sub tree
        root->right = f(preorder,mid+1,right); // Passing all right side of that index to right sub tree
        return root;   
        
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        ind = 0;
        m.clear();
        for(int i=0;i<inorder.size();i++) m[inorder[i]] = i; // Map for storing index of root nodes  
        
        return f(preorder,0,preorder.size()-1); 
    }
};

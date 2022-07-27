class Solution {
    void flattenCurrentNode(TreeNode* currNode, TreeNode* &prevNode){
       if(currNode == nullptr) return;
        
        TreeNode* leftNode = currNode->left;
        TreeNode* rightNode = currNode->right;
        if(prevNode == nullptr){
            prevNode = currNode;
        }
        else{
            prevNode->right = currNode;
            prevNode->left = nullptr;
            prevNode = prevNode->right; 
        }
        flattenCurrentNode(leftNode, prevNode);
        flattenCurrentNode(rightNode, prevNode);
    }
public:
    void flatten(TreeNode* root) {
        TreeNode* currNode = root;
        TreeNode* prevNode = nullptr;
        flattenCurrentNode(currNode, prevNode);
    }
};

class Solution {
public:
    // TC: O(n)
    // SC: O(max_level)
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ans;
        
        // edge case
        if (!root) {
            return ans;
        }
        
        queue<TreeNode*> queue;
        queue.push(root);
        
        while (!queue.empty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode* node = queue.front();
                queue.pop();
                
                if (node->left) {
                    queue.push(node->left);
                }
                if (node->right) {
                    queue.push(node->right);
                }
                
                if (i == size - 1) {    // rightmost node in the level
                    ans.push_back(node->val);
                }
            }
        }
        
        return ans;
    }
};

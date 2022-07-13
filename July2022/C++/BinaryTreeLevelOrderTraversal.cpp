// BFS Traversal
class Solution {
public:
    // TC: O(n)
    // SC: O(max_level)
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        
        if (!root) {
            return ans;
        }
        
        queue<TreeNode*> queue;
        queue.push(root);
        
        vector<int> currList;
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
                currList.push_back(node->val);
            }
            ans.push_back(currList);
            currList.resize(0);
        }
        
        return ans;
    }
};


// DFS Traversal
class Solution {
private:
    void helper(TreeNode* node, int height, vector<vector<int>>& ans) {
        if (!node) {
            return;
        }
        if (ans.size() == height) { // visiting the level for the first time
            ans.push_back(vector<int>());
        }
        
        ans[height].push_back(node->val);
        helper(node->left, height + 1, ans);
        helper(node->right, height + 1, ans);
    }
    
public:
    // TC: O(n)
    // SC: O(height)
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        helper(root, 0, ans);        
        return ans;
    }
};

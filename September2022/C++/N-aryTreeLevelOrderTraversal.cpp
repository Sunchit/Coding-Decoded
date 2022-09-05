// https://leetcode.com/problems/n-ary-tree-level-order-traversal/
class Solution {
public:
    // TC: O(n)
    // SC: O(log(n))
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> ans;
        if (root == NULL) {
            return ans;
        }
        
        queue<Node*> queue;
        queue.push(root);
        
        while (!queue.empty()) {
            int size = queue.size();
            vector<int> level;
            for (int i = 0; i < size; i++) {
                Node* node = queue.front();
                queue.pop();
                for (Node* it : node->children) {
                    if (it != NULL) {
                        queue.push(it);
                    }
                }
                level.push_back(node->val);
            }
            ans.push_back(level);
        }
        
        return ans;
    }
};

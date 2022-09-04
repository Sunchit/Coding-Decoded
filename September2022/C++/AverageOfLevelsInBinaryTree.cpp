// https://leetcode.com/problems/average-of-levels-in-binary-tree/
class Solution {
public:
    // TC: O(n)
    // SC: O(logn)
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> ans;
        queue<TreeNode*> queue;
        queue.push(root);
        
        while (!queue.empty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode* node = queue.front();
                queue.pop();
                if (node->left != NULL) {
                    queue.push(node->left);
                }
                if (node->right != NULL) {
                    queue.push(node->right);
                }
                sum += node->val;
            }
            ans.push_back(sum / size);
        }
        
        return ans;
    }
};

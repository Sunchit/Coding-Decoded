// https://leetcode.com/problems/all-paths-from-source-to-target/

// DFS
class Solution {
private:
    void helper(int node, vector<vector<int>>& graph, vector<vector<int>>& ans, vector<int>& curr) {
        curr.push_back(node);
        
        // base case
        if (node == graph.size() - 1) {
            ans.push_back(curr);
            curr.pop_back();
            return;
        }
        
        for (int &it : graph[node]) {
            helper(it, graph, ans, curr);
        }
        
        curr.pop_back();
    }
    
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<vector<int>> ans;
        vector<int> curr;
        helper(0, graph, ans, curr);
        return ans;
    }
};


// BFS
class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        int startNode = 0;
        int endNode = graph.size() - 1;
        
        vector<vector<int>> ans;
        queue<vector<int>> queue;
        
        queue.push({0});
        
        while (!queue.empty()) {
            vector<int> list = queue.front();
            queue.pop();
            int lastNode = list[list.size() - 1];
            if (lastNode == endNode) {
                ans.push_back(list);        
            }
            
            for (int &it : graph[lastNode]) {
                vector<int> copyList = list;
                copyList.push_back(it);
                queue.push(copyList);
            }
        }
        
        return ans;
    }
};

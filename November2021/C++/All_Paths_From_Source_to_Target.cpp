//author:shyam2520
// https://leetcode.com/problems/all-paths-from-source-to-target/

class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<vector<int>> res;
        for(auto& i:graph[0])
            explore(i,graph,res,{0,i});
        return res;
    }
    
        void explore(int i,vector<vector<int>>& graph,vector<vector<int>>& res,vector<int> temp)
        {
        if(i==graph.size()-1) 
        {
            // temp.push_back(i);
            res.push_back(temp);
            return ;
        }
        
        for(auto& j:graph[i])
        {
            temp.push_back(j);
            explore(j,graph,res,temp);
            temp.pop_back();
        }
            
    }
};
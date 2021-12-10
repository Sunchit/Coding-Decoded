class Solution {
    
public:
    bool canReach(vector<int>& arr, int start) {
        vector<pair<bool,bool>> visited(arr.size(),{false,false});
        return  dfs(arr,start,visited);
    }
    
    bool dfs(vector<int>& arr,int idx,vector<pair<bool,bool>>& visited)
    {
        if(idx<0 || idx>=arr.size()) return false;
        
        if(arr[idx]==0) return true;
        
        if(visited[idx].first)
            return visited[idx].second;
        
        visited[idx].first=true;
        visited[idx].second= dfs(arr,idx+arr[idx],visited) || dfs(arr,idx-arr[idx],visited);
        return visited[idx].second;
    }
};
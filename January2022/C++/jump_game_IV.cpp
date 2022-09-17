class Solution {
    int bfs(vector<int>& arr, vector<bool> &vis, map<int, set<int>> &mp, int start, int end)
    {
        queue<pair<int,int>> q;
        int steps = 0;
        q.push({start,0});
        vis[start] = true;
        while(!q.empty())
        {
            pair<int,int> cur = q.front();
            q.pop();
            set<int> temp = mp[arr[cur.first]];
            temp.insert(cur.first - 1);
            temp.insert(cur.first + 1);
            for(int next : temp)
            {
                mp[arr[cur.first]].erase(next);
                if(next >= 0 && next < arr.size() && vis[next] != true)
                {
                    if(next == end)
                        return cur.second+1;
                    else
                    {
                        q.push({next, cur.second+1});
                        vis[next] = true;
                    }
                }
            }
        }
        return -1;
    }
    
public:
    int minJumps(vector<int>& arr) 
    {
        if(arr.size() <= 2)
            return arr.size() - 1;
        map<int, set<int>> mp;
        for(int i = 0; i < arr.size(); i++)
            mp[arr[i]].insert(i);
        vector<bool> vis(arr.size(), false);
        return bfs(arr, vis, mp, 0, arr.size()-1);
    }
};

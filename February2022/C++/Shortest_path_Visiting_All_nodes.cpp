class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        if(graph.size()==1) return 0;
        int n=graph.size();
        int final_state=(1<<n) - 1;
        int shortest_path=0;
        queue<vector<int>> q;
        vector<vector<int>> visited(n,vector<int>(final_state));
        for(int i=0;i<n;i++) q.push({i,1<<i});
        while(!q.empty())
        {
            ++shortest_path;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                // vector<int> head=q.front();
                int nodeid=q.front()[0];
                int visited_bit=q.front()[1];
                q.pop();
                for(auto& i:graph[nodeid])
                {
                    int new_visited_bit=visited_bit|(1<<i);
                    if(new_visited_bit==final_state) return shortest_path;
                    if(visited[i][new_visited_bit]==1) continue;
                    visited[i][new_visited_bit]=1;
                    q.push({i,new_visited_bit});
                }

            }
        }
        
        return -1;
    }
};
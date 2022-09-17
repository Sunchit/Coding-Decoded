class Solution 
{
  public:
    
    int shortestPathLength(vector<vector<int>> &graph) 
    {   
        int n = graph.size();
        if(n==1)
        {
            return 0;
        }
        
        queue<pair<int,int>> q;
        for(int node=0 ; node<n ; node++)
        {
            q.push({node, (1<<node)});
        }
        
        int finalState = ((1<<n) - 1), shortestPath = 0;
        
        vector<vector<bool>> visited(n, vector<bool>(finalState, false));
        
        while(!q.empty())
        {
            shortestPath++;
            
            int sz = q.size();
            
            while(sz--)
            {
                auto &p = q.front();
                int currNode = p.first, currState = p.second;
                q.pop();
                
                for(int &nextNode: graph[currNode])
                {
                    int nextState = (currState | (1<<nextNode));
                    if(nextState == finalState)
                    {
                        return shortestPath;
                    }
                    
                    if(!visited[nextNode][nextState])
                    {
                        visited[nextNode][nextState] = true;
                        q.push({nextNode, nextState});
                    }
                }
            }
        }
        
        return -1;
    }
};

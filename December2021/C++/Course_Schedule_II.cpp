class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(numCourses,vector<int>());
        vector<int> indegree(numCourses);
        for(auto& edge:prerequisites)
        {
            adj[edge[1]].push_back(edge[0]);
            indegree[edge[0]]++;
        }
        queue<int> q;
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                q.push(i);
        }
        vector<int> res;
        while(q.size())
        {
            int size=q.size();
            while(size--)
            {
                vector<int> course=adj[q.front()];
                res.push_back(q.front());
                q.pop();
                for(int i=0;i<course.size();i++)
                {
                    indegree[course[i]]--;
                    if(indegree[course[i]]==0)
                        q.push(course[i]);
                }
            }
        }
        if(res.size()!=numCourses) 
            return {};
        return res;
    }
};
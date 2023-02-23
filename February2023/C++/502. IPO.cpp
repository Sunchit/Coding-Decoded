class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        
        int n = profits.size();
        vector<pair<int,int>> v;
        
        for(int i=0;i<n;i++)
        {
            v.push_back({capital[i], profits[i]});
        }
        
        priority_queue<int> pq;
        sort(v.begin(), v.end());
        int i = 0;
        
        while(k--)
        {
            while(i<n and v[i].first<=w)
            {   
                pq.push(v[i].second);
                i++;
            }
            
            if(pq.empty()) break;
            w += pq.top(); pq.pop();
        }
        return w;
    }
};

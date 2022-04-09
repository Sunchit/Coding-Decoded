class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> dict;
        for(auto& i:nums) dict[i]++;
        priority_queue<pair<int,int>> q;
        for(auto& i:dict) q.push({i.second,i.first});
        
        vector<int> res;
        while(k--)
        {
            res.push_back(q.top().second);
            q.pop();
        }
        return res;
    }
};
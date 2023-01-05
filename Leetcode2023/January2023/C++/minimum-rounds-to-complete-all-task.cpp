class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        int n = tasks.size();
        int rounds = 0;
        
        unordered_map<int,int> m;
        for(int i=0;i<n;i++) m[tasks[i]]++;
        
        for(auto &it:m)
        {
            if(it.second == 1) return -1;
            else if(it.second == 2) rounds++;
            else 
            {
                rounds += ceil(double(it.second)/3.0);    
            }
        }
        return rounds;
    }
};

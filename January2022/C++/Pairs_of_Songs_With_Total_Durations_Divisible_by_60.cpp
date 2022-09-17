class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        vector<int> dict(60,0);
        int res=0;
        for(auto& i:time)
        {
            res+=dict[(60-i%60)%60];
            ++dict[i%60];
        }
        return res;
    }
};
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> dict;
        int sum=0,res=0;
        dict[0]++;
        for(auto& i:nums)
        {
            sum+=i;
            if(dict.count(sum-k)) res+=dict[sum-k];
            dict[sum]++;
        }
        return res;
    }
};
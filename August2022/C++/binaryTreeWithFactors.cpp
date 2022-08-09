class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& nums) {
        
        map<int,long long int> m;
        sort(nums.begin(),nums.end());
        
        for(int i=0;i<nums.size();i++) m[nums[i]]++;
        
        for(int i=1;i<nums.size();i++)
        {
            auto it3 = m.find(nums[i]);
            long long int c = 0;
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0)
                {
                    auto it = m.find(nums[i]/nums[j]);
                    auto it1 = m.find(nums[j]);
                    if(it!=m.end())
                   {
                        c += it->second*it1->second;
                   }                                   
                }
            }
            it3->second += c;
        }
        long long sum = 0;
        for(auto &it:m) sum += it.second;
        
        return sum%1000000007;
    }
};

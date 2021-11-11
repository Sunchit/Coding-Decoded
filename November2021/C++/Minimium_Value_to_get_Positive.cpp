class Solution {
public:
    int minStartValue(vector<int>& nums) {
        int sum=0,min_val=0;
        for(auto& i:nums)
        {
            sum+=i;
            min_val=min(min_val,sum);
        }
        return 1-min_val;
    }
};
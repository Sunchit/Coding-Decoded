// author : shyam2520
// problem : https://leetcode.com/problems/single-number-iii/
class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        long long int x=0,y=0,res=nums[0];
        for(int i=1;i<nums.size();i++)
        {
            res^=nums[i];
        }
        
        long long int rbs=res & ~(res-1);
        for(auto& i:nums)
        {
            if(rbs&i)
                x^=i;
            else
                y^=i;
        }
        return {(int)x,(int)y};
    }
};
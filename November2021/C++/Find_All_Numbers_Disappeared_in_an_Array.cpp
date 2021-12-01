// author:shyam2520
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
      for(int i=0;i<nums.size();i++)
      {
          // cout<<nums[nums[i]-1]<<endl;
          if(nums[abs(nums[i])-1]<0)
              continue;
          else
              nums[abs(nums[i])-1]=-(nums[abs(nums[i])-1]);
      }
      vector<int> res;
      for(int i=0;i<nums.size();i++)
          // cout<<i<<" "<<nums[i]<<endl;
          if(nums[i]>0) res.push_back(i+1);
      return res;
    }
};
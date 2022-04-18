//https://leetcode.com/problems/next-permutation/
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int first = nums.size() - 1;
        
        while(first>=1 && nums[first - 1] >= nums[first]){
            first--;
        }
        
        // cout<<first;
        // return;
        if(first == 0)
        {
            reverse(nums.begin(),nums.end());
            return;
        }
        first--;
        int second = nums.size() - 1;
        while(second>first && nums[first] >= nums[second]){
            second--;
        }
        swap(nums[first],nums[second]);
        int start = first + 1;
        // int end = nus.size() - 1;
        reverse(nums.begin() + start,nums.end());
    }
};

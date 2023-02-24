// @Sarang661
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        // 1 2 3 3 3 3 3 4 4 5 5 5
        int len = 1;
        int start = 0;
        int end = 0;
        
        for(int index = 0;index<nums.size();index++){
            end = index;
            int k = nums[end];
            
            if(k!=nums[start]){
                len++;
                nums[start+1] = k;
                start++;
            }
        }
        
        return len;
    }
};
class Solution {
    // TC : O(n)
    // SC : O(1)
    public boolean checkPossibility(int[] nums) {
        int modificationCount = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] > nums[i]){
                // downhill
                modificationCount++;

                if(i>=2 && nums[i-2]> nums[i]){
                    nums[i]  =nums[i-1]; // increasing
                } else{
                    nums[i-1] = nums[i]; // decreasing
                }
            }
        }

        return modificationCount<=1;

    }
}
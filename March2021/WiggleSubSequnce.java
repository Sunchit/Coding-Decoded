class Solution {
    // TC : O(n)
    // SC : O(1)
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }

        int up =1;
        int down =1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] < nums[i+1]){ // uphill case
                up = down +1;
            } else if(nums[i] > nums[i+1]){ // downhill case
                down = up +1;
            }
            //System.out.println(up + " "+ down);
        }
        return Math.max(up, down);

    }
}
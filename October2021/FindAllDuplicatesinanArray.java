class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int indexToBeNegative = Math.abs(nums[i])-1;
            if(nums[indexToBeNegative] < 0){
                ans.add(Math.abs(nums[i]));
            } else {
                nums[indexToBeNegative] = -nums[indexToBeNegative];
            }

        }
        return ans;

    }
}
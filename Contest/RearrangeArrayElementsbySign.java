class Solution {
	// TC : O(n)
	// SC: O(n)
	public int[] rearrangeArray(int[] nums) {
		int len = nums.length;
		int[] ans = new int[len];
		int positiveIndex = 0;
		int negativeIndex = 1;
		for(int i=0;i<len;i++){
			if(nums[i]>0){
				ans[positiveIndex] = nums[i];
				positiveIndex += 2;
			} else {

				ans[negativeIndex] = nums[i];
				negativeIndex += 2;
			}
		}
		return ans;
	}
}
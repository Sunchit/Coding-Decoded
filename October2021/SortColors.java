class Solution {
	public void sortColors(int[] nums) {

		int zeroIndex = 0;
		int twoIndex = nums.length-1;
		for(int i = zeroIndex; i<=twoIndex;) {
			if(nums[i]==0) {

				swap(nums, zeroIndex, i);
				i++;
				zeroIndex++;
			}else if(nums[i]==2) {

				swap(nums, twoIndex, i);
				twoIndex--;
			}else {
				// 1
				i++;
			}
		}
	}

	private void swap(int[] nums, int start, int end){
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
}
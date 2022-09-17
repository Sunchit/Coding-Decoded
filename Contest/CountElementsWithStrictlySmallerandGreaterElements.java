class Solution {
	public int countElements(int[] nums) {
		Arrays.sort(nums); //TC:O(nlogn)
		int low = 0;
		int high= nums.length-1;
		if(nums[0] == nums[nums.length-1]){
			return 0;
		} else {

			while(low<nums.length-1 && nums[low] == nums[low+1]){
				low++;
			}
			while(high>=1 && nums[high] == nums[high-1]){
				high--;
			}
			return high - low-1;
		}
	}
	// TC : O(n)
	public int countElements(int[] nums) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int el: nums){
			max =Math.max(el, max);
			min =Math.min(el, min);
		}
		int count = 0;
		for(int el: nums){
			if(el < max && min < el){
				count++;
			}
		}
		return count;
	}
}
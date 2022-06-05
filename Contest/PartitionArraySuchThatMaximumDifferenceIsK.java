class Solution {
	// TC : O(nlogn)
	// SC : O(1)
	public int partitionArray(int[] nums, int k) {

		if(nums.length <=1) { return nums.length; }

		Arrays.sort(nums);

		int ans = 1;
		int min =nums[0];
		for(int i=1;i<nums.length;i++){

			if(nums[i]- min >k){

				// element out of range k

				min = nums[i];

				ans++;
			} else {

				// element within of range k
			}
		}
		return ans;
	}
}
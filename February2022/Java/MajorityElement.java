class Solution {

	// TC : O(n)
	// SC :O(1)
	public int majorityElement(int[] nums) {
		int count = 1;
		int majorityEl = nums[0];
		for(int i=1;i<nums.length;i++) {
			int el = nums[i];
			if(el == majorityEl){
				count++;
			} else{
				count--;
			}
			if(count == 0){
				majorityEl = nums[i];
				count =1;
			}
		}

		return majorityEl;

	}
}
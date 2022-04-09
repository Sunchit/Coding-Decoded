class Solution {
	// TC : O(n)
	// SC : O(n)
	public int countHillValley(int[] nums) {
		int count = 0;
		int n = nums.length;
		List<Integer> updatedArray = new ArrayList<>();
		for(int i=0;i+1<n;i++){
			if(nums[i] > nums[i+1]){
				updatedArray.add(nums[i]);
			} else if(nums[i] < nums[i+1]){
				updatedArray.add(nums[i]);
			} else {
				//Skip because equal
			}
		}

		updatedArray.add(nums[n-1]);
		int ans = 0;
		for(int i=1;i+1<updatedArray.size();i++){
			if((updatedArray.get(i) > updatedArray.get(i-1) && updatedArray.get(i) > updatedArray.get(i+1)) ||(updatedArray.get(i) < updatedArray.get(i-1) && updatedArray.get(i) < updatedArray.get(i+1))) {
				ans++;
			}
		}
		return ans;
	}
}
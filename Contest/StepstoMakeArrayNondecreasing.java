class Solution {

	// TC : O(n)
	// SC : O(n)
	public int totalSteps(int[] nums) {

		int n = nums.length;
		int ans = 0;

		// Element, Count
		Stack<Pair<Integer,Integer>> st = new Stack<>();

		st.push(new Pair<>(nums[n-1],0));

		for(int i=n-2; i>=0; i--) {
			int count = 0;
			while(!st.isEmpty() && nums[i] > st.peek().getKey()) {
				count = Math.max(count+1, st.peek().getValue());
				st.pop();
			}
			ans = Math.max(ans, count);
			st.push(new Pair(nums[i], count));
		}

		return ans;
	}
}
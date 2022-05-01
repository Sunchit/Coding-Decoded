class Solution {
	// TC : O(n2)
	// SC : O(n2)
	public int countDistinct(int[] nums, int k, int p) {
		Set<String> set = new HashSet<>();

		for(int i=0; i<nums.length; i++) {
			int count = 0;

			StringBuilder sb = new StringBuilder();
			for(int j=i; j<nums.length; j++) {

				if(nums[j]%p == 0) {
					count++;
				}

				if(count > k) {
					break;
				}

				sb.append(nums[j] + "_");

				set.add(sb.toString());
			}
		}

		for(String s: set){
			System.out.println(s);
		}

		return set.size();
	}
}
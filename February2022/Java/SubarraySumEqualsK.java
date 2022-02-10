
// @saorav21994
// TC : O(n)
// SC : O(n)

/*
  basic concept -> if cumulative_sum(num[i]) - cumulative_sum(num[j]) == k then the sum of numbers between i and j is k. so c_sum(num[i])-k = c_sum(num[j]) -> which means
	frequency of curSum-k will give the number of subarray(s) till this index with sum=k.
*/


class Solution {
    public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int curSum = 0;
		int res = 0;
        map.put(0, 1);
		for (int n : nums) {
			curSum += n;
			res += map.getOrDefault(curSum-k, 0);
			map.put(curSum, map.getOrDefault(curSum, 0) + 1);
		}
		return res;
    }
}

class Solution {
	// TC : O(nlogn)
	// SC : O(1)
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		int min = Integer.MAX_VALUE;
		int n = arr.length;

		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(arr);

		for(int i = 0; i < n - 1; i++)
			min = Math.min(min, arr[i+1] - arr[i]);

		for(int i = 0; i < n - 1; i++)
			if( min == arr[i + 1] - arr[i])
				res.add(Arrays.asList(arr[i], arr[i + 1]));

		return res;
	}
}
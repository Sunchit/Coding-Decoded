class Solution {

	// TC : O(nlogn)
	// Sc : O(1)
	public long minimumRemoval(int[] beans) {
		Arrays.sort(beans);

		long total =0;
		long min=Long.MAX_VALUE;

		int n=beans.length;

		for(int bean:beans) {
			total +=bean;
		}

		for(int i=0;i<n;i++)
		{
			long possibleAns = total -((n-i+0L)*beans[i]);
			min=(long)Math.min(min,possibleAns);

		}
		return min;
	}
}
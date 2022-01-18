class Solution {

	private boolean canFit(int n, long timeSpan, int[] batteries) {
		long currBatSum = 0;
		long targetBatSum = n * timeSpan;

		for (int bat : batteries) {
			if (bat < timeSpan) {
				currBatSum += bat;
			} else {
				currBatSum += timeSpan;
			}

			if (currBatSum >= targetBatSum) {
				return true;
			}
		}

		return currBatSum >= targetBatSum;

	}



	public long maxRunTime(int n, int[] batteries) {
		long totalSum = 0;

		long low = 0;
		for (int bat : batteries) {
			totalSum += bat;
			low  =Math.min(bat, low);
		}

		long high = (totalSum /n)+1; //[l,h]
		long ans = -1;
		// binary search
		while (low < high) {
			long mid = low + (high- low) / 2;

			if (canFit(n, mid, batteries)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return ans;
	}
}
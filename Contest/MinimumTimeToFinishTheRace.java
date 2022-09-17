class Solution {
	public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
		// max upto 18 laps can remain independent
		// then for future ones need to reuse
		int[] withoutChange = new int[19];
		Arrays.fill(withoutChange, Integer.MAX_VALUE);
		for (int[] tire: tires) {
			int f = tire[0];
			int r = tire[1];
			int timeToCompleteLaps = 0;
			for (int i = 1; i <= numLaps; i++) {
				int t =  f * (int) Math.pow(r, i - 1);
				timeToCompleteLaps += t;
				if (timeToCompleteLaps > Math.pow(2, 17)) {
					break; //more than required time, impossible to reach by going straight
				}
				withoutChange[i] = Math.min(withoutChange[i], timeToCompleteLaps);
			}
		}

		// Knapsack problem
		int[] dp = new int[numLaps + 1];
		for (int i = 1; i <= numLaps; i++) {
			dp[i] = i < 19? withoutChange[i] : Integer.MAX_VALUE;
			for (int j = 1; j < i; j++) {
				dp[i] = Math.min(dp[i], dp[j] + changeTime + dp[i - j]);
			}
		}
		return dp[numLaps];
	}
}
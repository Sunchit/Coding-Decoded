class Solution {

	// TC : O(n)
	// SC : O(n)
	public int peopleAwareOfSecret(int n, int delay, int forget) {

		long dp[] = new long[n + 1];
		long mod = (long)1e9 + 7;
		long noOfPeopleSharingSecret = 0;
		long ans = 0;

		// day 1 only one person knows the secret
		dp[1] = 1;



		// i stands for days
		for (int i = 2; i <= n; i++) {
			long noOfNewPeopleSharingSecret = dp[Math.max(i - delay, 0)];
			long noOfPeopleForgetingSecret = dp[Math.max(i - forget, 0)];
			noOfPeopleSharingSecret +=  (noOfNewPeopleSharingSecret  - noOfPeopleForgetingSecret + mod) % mod;
			// dp[i] means the number of people who found the secret on ith day.
			dp[i] = noOfPeopleSharingSecret;


		}



		for (int i = n - forget + 1; i <= n; i++) {
			ans = (ans + dp[i]) % mod;
		}
		return (int)ans;
	}
}
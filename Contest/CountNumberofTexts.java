class Solution {

	// TC : O(n)
	// SC : O(n)
	public int countTexts(String s) {
		int n =s.length();
		long dp [] =new long[n+1];
		dp[0]=1;

		int mod = 1000000007;
		for(int i=1;i<=n;i++)
		{
			char ch = s.charAt(i-1);


			dp[i]= (dp[i-1]);

			if((i)>=2 && s.charAt(i-2)==ch) dp[i] = (dp[i] + dp[i-2]) % mod;
			else continue;

			if((i)>=3 && s.charAt(i-3)==ch) dp[i]= ( dp[i]+dp[i-3] )  % mod;
			else continue;

			if( (ch=='7' || ch=='9') && (i)>=4 && s.charAt(i-4)==ch) dp[i] = (dp[i]+dp[i-4] )  % mod;

		}

		return (int)(dp[n] % mod);
	}
}
class Solution {
	Boolean[] dp = new Boolean[100000 + 1];
	public boolean winnerSquareGame(int n) {
		if (dp[n] != null) {
			return dp[n];
		}
		Boolean aliceWins = false;
		for (int move = 1; n >= move * move; move++) {
			if (n - move * move == 0) {
				// current player won
				aliceWins = true;
				break;
			} else {
				aliceWins = aliceWins || !winnerSquareGame(n - move * move);
			}
		}
		return dp[n] = aliceWins;
	}
}
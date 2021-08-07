public class Solution {
    // TC : O(n2)
    // SC: O(n2)
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        boolean[][] dp = buildMatrix(s, n);
        int[] totalCuts = new int[n];

        for (int j = 0; j < n; j++) {
            int cut = j;
            for (int i = 0; i <= j; i++) {
                if (dp[i][j]) {
                    cut = Math.min(cut, i == 0 ? 0 : totalCuts[i - 1] + 1);
                }
            }
            totalCuts[j] = cut;
        }

        return totalCuts[n - 1];
    }

    boolean[][] buildMatrix(String s, int n) {
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        return dp;
    }

}
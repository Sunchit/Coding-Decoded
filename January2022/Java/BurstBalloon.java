class BurstBalloon {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] iNums = new int[len+2];
        iNums[0] = 1;
        for(int i=0;i<len;i++){
            iNums[i+1]= nums[i];
        }
        iNums[len+1] =1;

        int[][] dp = new int[len+2][len+2];
        // TC O(n3) SC O(n2)
        for(int window=1;window<=len;window++){

            for(int left =1;left+ window < len+2;left++){
                int right = left + window -1;
                for(int i=left;i<=right;i++){
                    int currCost = iNums[left-1] * iNums[i] * iNums[right+1] + dp[left][i-1] + dp[i+1][right];
                    dp[left][right] = Math.max(dp[left][right], currCost);
                }
            }
        }
        return dp[1][len];

    }
}
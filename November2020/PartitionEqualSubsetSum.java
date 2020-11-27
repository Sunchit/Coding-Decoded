class PartitionEqualSubsetSum {
    // TC : O(n*m) , where n is the totalSum/2, m is num of elements in input array
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int el: nums){
            totalSum += el;
        }

        if(totalSum%2 !=0){
            return false;
        }
        totalSum = totalSum/2;
        boolean[][] dp = new boolean[nums.length +1][totalSum+1];

        for(int i=0;i<=nums.length;i++){
            dp[i][0] = true;
        }

        for(int i =1;i<=nums.length;i++){
            for(int j=1;j<=totalSum;j++){
                dp[i][j] = dp[i-1][j];
                if(!dp[i-1][j]) {
                    if(j >= nums[i-1]){
                        dp[i][j] = dp[i-1][j - nums[i-1]];
                    }
                }
            }
        }
        return dp[nums.length][totalSum];

    }
}
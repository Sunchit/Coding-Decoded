class Solution {
	// Tc: O(n)
	// SC : O(n)
	public int deleteAndEarn(int[] nums) {
		int[] freq = new int[10002];
		int[] dp = new int[10002];

		for(int i = 0; i < nums.length; i++){
			freq[nums[i]]++;
		}

		dp[0] = 0;
		dp[1] = 1* freq[1];
		for(int i = 2; i < 10002; i++){
			dp[i] = Math.max(dp[i-1], dp[i-2] + i * freq[i]);
		}
		return dp[10001];
	}
}

// Author : @romitdutta10
// TC: O(N)
// SC : O(1)
// Problem : https://leetcode.com/problems/delete-and-earn/
// Same solution just storing the previous two values instead of all values in the array

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10002];
        
        
        for(int num : nums) {
            freq[num]++;
        }
        
        int twoStepsBack = 0;
        int oneStepBack = 1 * freq[1];
        
        for(int i=2; i<10001; i++) {
            int temp = Math.max(oneStepBack, i * freq[i] + twoStepsBack);
            twoStepsBack = oneStepBack;
            oneStepBack = temp;
            
        }
        
        return Math.max(oneStepBack, twoStepsBack);
    }
}

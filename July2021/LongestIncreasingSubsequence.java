class Solution {
    //TC: O(n2)
    // SC : O(n)
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    int max = 1;
    for (int i = 0; i < nums.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          max = Math.max(dp[i], max);
        }
      }
    }
    return max;
  }

  // TC : O(nlogn)
  // SC: O(n)
  public int lengthOfLIS(int[] nums) {
    TreeSet<Integer> bst = new TreeSet<>();
    for (int num : nums) {
      Integer higherOrEqual = bst.ceiling(num);
      if (higherOrEqual == null) {
        bst.add(num);
      }
      else {
        bst.remove(higherOrEqual);
        bst.add(num); // O(logn)
      }
    }

    return bst.size();
  }
}



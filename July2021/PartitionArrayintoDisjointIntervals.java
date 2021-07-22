class Solution {

  // TC : O(n)
  // SC : O(n)
  public int partitionDisjoint(int[] nums) {
    int[] lmax = new int[nums.length];
    int[] rmin = new int[nums.length];

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
      lmax[i] = max;
    }

    int min = Integer.MAX_VALUE;
    for (int i = nums.length - 1; i >= 0; i--) {
      min = Math.min(min, nums[i]);
      rmin[i] = min;
    }

    for (int i = 1; i < nums.length; i++) {
      if (lmax[i - 1] <= rmin[i])
        return i;
    }
    return nums.length;
  }

  // TC : O(n)
  // SC : O(1)
  public int partitionDisjoint(int[] nums) {
    int maxUntilI = nums[0];
    int maxInleftPartition = nums[0];
    int partitionId = 0;
    for (int i = 1; i < nums.length; i++) {
      maxUntilI = Math.max(maxUntilI, nums[i]);
      if (nums[i] < maxInleftPartition) {
        maxInleftPartition = maxUntilI;
        partitionId = i;
      }
    }
    return partitionId + 1;
  }


}
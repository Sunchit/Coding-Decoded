class Solution {
  // TC : O(n2)
  // SC :O(1)
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums); // O(nlogn)
    int closesetSum = nums[0] + nums[1] + nums[nums.length - 1];
    for (int i = 0; i < nums.length - 2; i++) {
      int start = i + 1;
      int end = nums.length - 1;
      while (start < end) {
        int currSum = nums[i] + nums[start] + nums[end];
        if (currSum > target) {
          end--;
        } else {
          start++;
        }

        if (Math.abs(currSum - target) < Math.abs(closesetSum - target)) {
          closesetSum = currSum;
        }
      }
    }
    return closesetSum;
  }
}
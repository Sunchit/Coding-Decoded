class Solution {

    // TC : O(n)
    // SC : O(n)
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int start=0;
        int i = 0; // ending pointer
        int runningSum = 0;
        int maxSum = 0;
        while(i<nums.length) {
            int currEl  = nums[i];
            if(!set.contains(currEl)) {
                set.add(currEl);
                runningSum += currEl;
                maxSum = Math.max(maxSum, runningSum);
                i++;
            } else {
                int deleteEl = nums[start];
                set.remove(deleteEl);
                runningSum = runningSum  - deleteEl;
                start++;
            }
        }
        return maxSum;

    }
}
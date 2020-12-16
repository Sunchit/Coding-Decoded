class SquaresOfSortedArray {
    // TC : O(n)
    // SC : O(1)
    public int[] sortedSquares(int[] nums) {
      int len = nums.length;
        int[] ans =new int[len];
        int k = len -1;
        int start = 0;
        int end = len -1;
        while(!(start>end)){
            if(Math.abs(nums[start]) > Math.abs(nums[end])){
                ans[k] =nums[start] * nums[start];
                start++;
                k--;
            } else{
                ans[k] = nums[end] * nums[end];
                end--;
                k--;
            }
        }
        return ans;
    }
}
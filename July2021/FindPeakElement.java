class Solution {

  // TC : O(logn)
  // SC : O(1)
  public int findPeakElement(int[] nums) {
    int low = 0;
    int high = nums.length-1;

    while(low< high){
      int mid = low + (high-low)/2;
      if(nums[mid]<nums[mid+1]){
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }
}
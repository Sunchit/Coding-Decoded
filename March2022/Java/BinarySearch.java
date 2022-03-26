

// @saorav21994
// TC : O(logn)
// SC : O(1)

class Solution {
  
    // inbuilt java function
  
    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return -1;
        }
        return index;
    }
    
  
    // normal binary search algorithm
  
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e-s)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                s += 1;
            }
            else
                e -= 1;
        }
        return -1;
    }
}
// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int search(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                j=m-1;
            }else{
                i=m+1;
            }
        }
        
        return -1;
    }
}

// https://leetcode.com/problems/search-in-rotated-sorted-array/
// @author: anuj0503
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            // If target found, return index
            if(target == nums[mid])
                return mid;
            
            // If first part is sorted
            if(nums[low] < nums[mid]){
                // If number lie in first part
                if(target >= nums[low] && mid - 1 >= 0 && target <= nums[mid - 1])
                    high = mid - 1;
                else // otherwise, it will lie on other part
                    low = mid + 1;
            } else{ // Else, second must me sorted
                // if number lie on second part
                if(mid + 1 < nums.length && target >= nums[mid + 1] && target <= nums[high])
                    low = mid + 1;
                else // Else, number lie on first part
                    high = mid - 1;
            }
        }
        
        return -1;
    }
}

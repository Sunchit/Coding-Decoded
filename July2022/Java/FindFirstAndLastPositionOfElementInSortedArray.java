
// @saorav21994
// TC : O(logn)
// SC : O(1)

class Solution {
    
    public int findFirst(int[] nums, int s, int e, int target) {
        while (s <= e) {
            int mid = (s+e)/2;
            if ((mid == 0 || nums[mid-1] < target) && nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) s = mid+1;
            else e = mid-1;
        }
        return -1;
    }
    
    public int findLast(int[] nums, int s, int e, int target) {
        while (s <= e) {
            int mid = (s+e)/2;
            int l = nums.length;
            if ((mid == l-1 || nums[mid+1] > target) && nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) e = mid-1;
            else s = mid+1;
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int l = nums.length;
        if (l == 0) return new int[] {-1,-1};
        int i = findFirst(nums, 0, l-1, target);
        int j = findLast(nums, 0, l-1, target);
        return new int[] {i, j};
    }
    
    
}

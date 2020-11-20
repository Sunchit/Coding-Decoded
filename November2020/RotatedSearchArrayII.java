class RotatedSearchArrayII {
    // Binary Search
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        while(low<=high) {
            int mid  = low +(high - low)/2;
            if(target == nums[mid]){
                return true;
            }
            // check if left part is sorted or not
            if(nums[low]  < nums[mid]){
                if(target <nums[low] || target > nums[mid]){ // target is out of the left part boundary scope
                    low = mid +1;

                } else{
                    // target lies within this left part
                    high = mid -1;
                }
            } else if(nums[low] > nums[mid]){
                // right part is sorted
                if(target < nums[mid] || target > nums[high]){
                    high = mid -1;
                } else {
                    // target lies within the right part boundaries
                    low = mid+1;
                }
            } else{

                // duplicates
                low++; // => O(n) 111111112
            }

        }
        return false;
    }
}

// Time complexity o(n)
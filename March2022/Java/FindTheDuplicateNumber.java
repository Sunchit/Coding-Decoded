
// @saorav21994
// TC : O(n)
// SC : O(1)

// My original solution. Use -ve index marking and revert back to preserve original array.

class Solution {
    public int findDuplicate(int[] nums) {
        int mark = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                mark = cur;
                break;
            }
            nums[cur] *= -1;
        }
        
        // re-store the original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        
        return mark;
    }
}


// Slow-Fast pointer approach taken from LeetCode solutions. Same as we find in Linked List detect cycle problem.
// TC : O(n)
// SC : O(1), No modification to array whatsoever


class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);             // do-while loop to take care of indices

        slow = nums[0];
        
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}

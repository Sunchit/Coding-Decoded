
// @saorav212294

// TC - O(n)
// SC - O(1)

// If an element is majority it will beat out the combined frequency of the rest of the elements in the array


class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i])
                count += 1;
            else {
                count -= 1;
                if (count  < 0) {
                    count *= -1;
                    maj = nums[i];
                }
            }
        }
        return maj;
    }
}

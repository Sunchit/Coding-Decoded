
// @saorav21994

// Approach in code : maintain absolute minimum, 2nd absolute minimum and then check if current number is greater than both ----------- [ TC : O(n) ]
// Other Approach : create min array from left, max array from right, then check if current number is > left min and < right max -> return true ----------- [ TC : O(n) ]

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int l = nums.length;
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < m1) {   // maintain ABSOLUTE MINIMUM
                m1 = i;
            }
            if (i > m1) {       // maintain 2nd MINIMUM
                m2 = Math.min(m2, i);
            }
            if (i > m2) {       // if current is > than min and 2nd min, return true
                return true;
            }
        }
        return false;
    }
}

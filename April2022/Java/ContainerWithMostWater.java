
// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int maxArea(int[] height) {
        int l = height.length-1;
        int max = Integer.MIN_VALUE;
        int i = 0;
        while (i < l) {
            max = Math.max(max, Math.min(height[i], height[l]) * (l-i));
            if (height[i] < height[l])
                i += 1;
            else 
                l -= 1;
        }
        return max;
    }
}

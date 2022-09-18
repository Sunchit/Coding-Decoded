
// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxl = 0, maxr = 0, res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                maxl = Math.max(maxl, height[l]);
                res += (maxl-height[l]);
                l += 1;
            }
            else {
                maxr = Math.max(maxr, height[r]);
                res += (maxr-height[r]);
                r -= 1;
            }
        }
        return res;
    }
}

// https://leetcode.com/problems/trapping-rain-water/
class Solution {
public:
	// TC: O(n)
	// SC: O(1)
    int trap(vector<int>& height) {
        int left = 0, right = height.size() - 1;
        int maxl = 0, maxr = 0, res = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                maxl = max(maxl, height[left]);
                res += (maxl - height[left]);
                left += 1;
            } else {
                maxr = max(maxr, height[right]);
                res += (maxr - height[right]);
                right -= 1;
            }
        }
        
        return res;
    }
};

//https://leetcode.com/problems/container-with-most-water/
class Solution {
public:
    int maxArea(vector<int>& height) {
        int n = height.size();
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while(l<r){
           ans = max(ans,min(height[l],height[r]) * (r -l));
            if(height[l]>=height[r]){
                r--;
            }
            else{
                l++;
            }
        }
        return ans;
    }
};

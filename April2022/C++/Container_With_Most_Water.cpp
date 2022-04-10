class Solution {
public:
    int maxArea(vector<int>& height) {
        int l=0,r=height.size()-1;
        int res=0;
        while(l<r)
        {
            res=max(res,(r-l )* min(height[l],height[r]));
            if(height[l]<height[r]) l++;
            else r--;
        }
        return res;
    }
};
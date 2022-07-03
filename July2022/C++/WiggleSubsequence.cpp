class Solution {
public:

    // TC: O(n)
    // SC: O(1)
    int wiggleMaxLength(vector<int>& nums) {
        int n = nums.size();
        
        int up = 1;
        int down = 1;
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {    // uphill case
                up = down + 1;
            } else if (nums[i] > nums[i + 1]) {    // downhill case
                down = up + 1;
            }
        }
        
        return max(up, down);

    int wiggleMaxLength(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> up(n+1,0),down(n+1,0);
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j]) up[i] = max(up[i],down[j]+1);
                else if(nums[i]<nums[j]) down[i] = max(down[i],up[j]+1);
            }
        }
        return 1+max(up[n-1],down[n-1]);

    }
};

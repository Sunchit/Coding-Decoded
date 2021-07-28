/*
 Author - geekySapien
 QLink - https://leetcode.com/problems/find-peak-element/
*/


class Solution
{
public:
    int findPeakElement(vector<int> &nums)
    {
        vector<int> LR(nums.size(), -1);
        int ans = -1;
        vector<int> RL(nums.size(), -1);
        int n = nums.size();
        LR[n - 1] = 1;
        RL[0] = 1;
        for (int i = 0; i < n - 1; i++)
        {
            if (nums[i] > nums[i + 1])
                LR[i] = 1;
        }
        for (int i = n - 1; i > 0; i--)
        {
            if (nums[i] > nums[i - 1])
                RL[i] = 1;
        }
        for (int i = 0; i < n; i++)
        {
            if (LR[i] == RL[i] && LR[i] == 1)
                ans = i;
        }
        return ans;
    }
};
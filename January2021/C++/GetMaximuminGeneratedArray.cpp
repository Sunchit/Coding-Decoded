/**
 * @author ssrbazpur
 * Time Complexity:O(N)
 * Space Complexity:O(N)
 *
**/

class Solution
{
public:
    int getMaximumGenerated(int n)
    {
        vector<int> nums(n + 1, 0);

        int ans = 0;

        if (n >= 1)
        {
            ans = 1;
            nums[1] = 1;
        }

        for (int i = 1; 2 * i + 1 <= n; i++)
        {
            nums[2 * i] = nums[i];
            nums[2 * i + 1] = nums[i] + nums[i + 1];
        }

        for (int n : nums)
        {
            ans = max(ans, n);
        }

        return ans;
    }
};
/*
 Author - geekySapien
 QLink - https://leetcode.com/problems/maximum-length-of-repeated-subarray/
*/



class Solution
{
public:
    int findLength(vector<int> &nums1, vector<int> &nums2)
    {
        int row = nums1.size();
        int col = nums2.size();
        int t[row + 1][col + 1];
        int maxx = 0;
        memset(t, 0, sizeof(t));
        for (int i = 1; i < row + 1; i++)
        {
            for (int j = 1; j < col + 1; j++)
                if (nums1[i - 1] == nums2[j - 1])
                {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    maxx = max(maxx, t[i][j]);
                }
        }
        return maxx;
    }
};
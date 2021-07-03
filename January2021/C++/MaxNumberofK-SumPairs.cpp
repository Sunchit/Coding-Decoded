/*
@author ssrbazpur
Time COmplexity: O(N)
Space Complexity:O(N)
*/

class Solution
{
public:
    int maxOperations(vector<int> &nums, int k)
    {

        unordered_map<int, int> hm;

        int ans = 0;
        for (int i = 0; i < nums.size(); i++)
        {

            int second = k - nums[i];

            if (hm.find(second) != hm.end())
            {
                if (hm[second] > 0)
                {
                    ans++;
                    hm[second]--;
                }
                else
                {
                    hm[nums[i]]++;
                }
            }
            else
            {
                hm[nums[i]]++;
            }
        }
        return ans;
    }
};
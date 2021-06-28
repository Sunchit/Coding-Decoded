/**
 * @author ssrbazpur
 * @Time O(N)
 * @Space O(N)
 */

/*

Conceptual Overview:

[3,2,20,1,1,3], x = 10
Output: 5 (Remove last 3 and first 2)

subArraySum = TotalSum - x = 30-10 = 20 (So we want a Contiguous Array Length with sum 20)

Prefix Sum = [3,5,25,26,27,30]

*/

class Solution
{
public:
    int minOperations(vector<int> &nums, int x)
    {

        //key:prefixSum and value:Index
        unordered_map<int, int> hm;

        int totalSum = 0;
        for (int x : nums)
        {
            totalSum += x;
        }

        int subArraySum = totalSum - x;

        hm.insert({0, -1});
        int trackPrefixSum = 0;
        int subArraySumLength = -1;

        for (int i = 0; i < nums.size(); i++)
        {
            trackPrefixSum += nums[i];
            hm[trackPrefixSum] = i;
            if (hm.find(trackPrefixSum - subArraySum) != hm.end())
            {
                subArraySumLength = max(subArraySumLength, i - hm[trackPrefixSum - subArraySum]);
            }
        }

        return subArraySumLength != -1 ? nums.size() - subArraySumLength : subArraySumLength;
    }
};
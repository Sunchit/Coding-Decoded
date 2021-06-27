/**
 * @author ssrbazpur
 * @Time Complexity: O(NlogN)
 * @Space Complexity:O(1)
 */

class Solution
{
public:
    int numRescueBoats(vector<int> &people, int limit)
    {
        sort(people.begin(), people.end());

        int left = 0;
        int right = people.size() - 1;

        int ans = 0;
        while (left <= right)
        {
            int sum = people[left] + people[right];

            if (sum > limit)
            {
                right--;
                ans++;
            }
            else
            {
                left++;
                right--;
                ans++;
            }
        }

        return ans;
    }
};
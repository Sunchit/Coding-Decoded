/*
@author ssrbazpur
*/

class Solution
{
public:
    vector<int> mostCompetitive(vector<int> &nums, int k)
    {

        int elementsToRemove = nums.size() - k;

        vector<int> stack;

        for (int i = 0; i < nums.size(); i++)
        {

            int currVal = nums[i];

            while (stack.size() > 0 && currVal < stack[stack.size() - 1] && elementsToRemove > 0)
            {
                stack.pop_back();
                elementsToRemove--;
            }

            stack.push_back(currVal);
        }

        while (stack.size() > k)
        {
            stack.pop_back();
        }
        return stack;
    }
};
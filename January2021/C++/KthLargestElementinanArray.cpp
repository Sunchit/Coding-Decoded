/**
*  @author ssrbazpur 
* Time Complexity : Average- O(log N ) Worst- O(N)
* Space Complexity: O(log N)
*
*/

class Solution
{
public:
    int ans = -1;

    int findKthLargest(vector<int> &nums, int k)
    {
        helper(nums, k, 0, nums.size() - 1);
        return ans;
    }

    void helper(vector<int> &nums, int k, int left, int right)
    {

        if (left > right)
        {
            return;
        }
        int first = nums[left];
        int start = left + 1;
        int end = right;
        while (start <= end)
        {
            if (nums[start] < first && nums[end] > first)
            {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }

            else if (nums[start] >= first)
            {
                start++;
            }
            else
            {
                end--;
            }
        }

        int temp = nums[end];
        nums[end] = first;
        nums[left] = temp;

        if (end == k - 1)
        {
            ans = nums[end];
        }

        if (k > end + 1)
        {
            helper(nums, k, end + 1, right);
        }
        else
        {
            helper(nums, k, left, end - 1);
        }
    }
};
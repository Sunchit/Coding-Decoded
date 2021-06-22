/**
 * Author: Simranjeet Randhawa
 * Description: Kth Missing Positive Number
 * Time Complexity: O(logN)
 * Space Complexity: O(1) 
 * */

class Solution
{
public:
    //
    int findKthPositive(vector<int> &arr, int k)
    {

        int left = 0;
        int right = arr.size();

        while (left < right)
        {

            int mid = left + (right - left) / 2;
            if (arr[mid] - (mid + 1) >= k)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }

        return right + k;
    }
};
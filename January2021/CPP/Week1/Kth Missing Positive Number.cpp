class Solution
{
public:
    //Space:O(1) | Time:O(logN)
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
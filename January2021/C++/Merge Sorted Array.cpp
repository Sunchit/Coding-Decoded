/**
 * @author ssrbazpur
 * @Time Complexity: O(M+N) | Space:O(1)
 */

class Solution
{
public:
    void merge(vector<int> &nums1, int m, vector<int> &nums2, int n)
    {

        int p1 = m - 1;
        int p2 = n - 1;

        int track = nums1.size() - 1;

        while (track >= 0)
        {

            int firstVal = p1 >= 0 ? nums1[p1] : INT_MIN;
            int secondVal = p2 >= 0 ? nums2[p2] : INT_MIN;

            if (firstVal > secondVal)
            {
                nums1[track] = firstVal;
                p1--;
                track--;
            }
            else
            {
                nums1[track] = secondVal;
                p2--;
                track--;
            }
        }
    }
};
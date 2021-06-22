/**
 * Author: Simranjeet Randhawa
 * Description: Beautiful Arrangements
 * Time Complexity: O(k)
 * Space Complexity: O(N) where k is the number of valid permutation
 * */

class Solution
{
public:
    void swap(vector<int> &array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void perm(vector<int> array, int index, int &ans)
    {

        if (index >= array.size())
        {
            ans++;
            return;
        }

        for (int i = index; i < array.size(); i++)
        {
            swap(array, i, index);
            if (array[index] % index == 0 || index % array[index] == 0)
                perm(array, index + 1, ans);
            swap(array, i, index);
        }
    }

    int countArrangement(int n)
    {
        vector<int> array;
        for (int i = 0; i <= n; i++)
        {
            array.push_back(i);
        }
        int count = 0;
        perm(array, 1, count);
        return count;
    }
};
/**
 * Author: Simranjeet Randhawa
 * Description: Check Array Formation Through Concatenation
 * Let m and n be the no of elements in arr and pieces
 * Time Complexity: O(max(m,n))
 * Space Complexity: O(n)
 * */

class Solution
{

private:
    unordered_map<int, vector<int>> hm;

public:
    bool canFormArray(vector<int> &arr, vector<vector<int>> &pieces)
    {

        //Forming the Map
        for (vector<int> p : pieces)
        {
            hm.insert({p[0], p});
        }

        int i = 0;

        while (i < arr.size())
        {

            if (hm.find(arr[i]) == hm.end())
            {
                return false;
            }

            vector<int> piece = hm[arr[i]];
            for (int j = 0; j < piece.size(); j++)
            {
                if (arr[i] != piece[j])
                {
                    return false;
                }
                i++;
            }
        }

        return true;
    }
};
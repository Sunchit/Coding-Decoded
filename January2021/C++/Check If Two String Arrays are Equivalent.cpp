/**
 * @author ssrbazpur
 * @Question: Check If Two String Arrays are Equivalent 
 * @Time Complexity: O(N) 
 * @Space Complexity: O(1)
 */

class Solution
{
public:
    //SPace:O(1) | Time:O(n)
    bool arrayStringsAreEqual(vector<string> &word1, vector<string> &word2)
    {

        int row1 = 0, row2 = 0;
        int col1 = 0, col2 = 0;
        while (row1 < word1.size() && row2 < word2.size())
        {

            if (word1[row1][col1] != word2[row2][col2])
            {
                return false;
            }
            col1++;
            col2++;

            if (col1 >= word1[row1].size())
            {
                col1 = 0;
                row1++;
            }

            if (col2 >= word2[row2].size())
            {
                col2 = 0;
                row2++;
            }
        }

        if (row1 < word1.size() || row2 < word2.size())
            return false;

        return true;
    }
};

//Space:O(N) Solution
//         string one="";
//         for(string a:word1){
//             one+=a;
//         }
//         string two="";
//         for(string b:word2){
//             two+=b;        }

//         if(one==two) return true;
//         return false;

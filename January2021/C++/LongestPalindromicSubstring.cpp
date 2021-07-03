/***
 *
 * @author ssrbazpur
 * Time Complexity:O(N^2) 
 * 
*/

class Solution
{
public:
    vector<int> getPalindrome(string s, int left, int right)
    {

        while (left >= 0 && right <= s.size() - 1 && s[left] == s[right])
        {

            left--;
            right++;
        }

        return vector<int>{left + 1, right};
    }
    string longestPalindrome(string s)
    {

        if (s.size() == 0)
            return "";

        vector<int> ans = {0, 1};

        for (int i = 0; i < s.size(); i++)
        {

            vector<int> odd = getPalindrome(s, i, i);
            vector<int> even = getPalindrome(s, i, i + 1);

            if (odd[1] - odd[0] > even[1] - even[0])
            {
                if (ans[1] - ans[0] < odd[1] - odd[0])
                {
                    ans[1] = odd[1];
                    ans[0] = odd[0];
                }
            }
            else
            {
                if (ans[1] - ans[0] < even[1] - even[0])
                {
                    ans[1] = even[1];
                    ans[0] = even[0];
                }
            }
        }

        return s.substr(ans[0], ans[1] - ans[0]);
    }
};
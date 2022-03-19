
// @saorav21994
// TC : O(n)
// SC : O(1)


class Solution {
public:
    int scoreOfParentheses(string s) {
        int l = s.length();
        int count = 0;
        int res = 0;
        for (int i = 0; i < l; i++) {
            if (s[i] == '(')
                count += 1;
            else {
                count--;
                if (s[i-1] == '(') 
                    res += (int)pow(2, count);
            }
        }
        return res;
    }
};

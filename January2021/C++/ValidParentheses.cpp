/**
 * 
 * @author ssrbazpur
 * 
 * */

class Solution
{
public:
    bool isValid(string s1)
    {
        stack<char> s;
        bool ans = true;
        for (char a : s1)
        {
            if (s.empty())
            {
                s.push(a);
            }
            else
            {
                char t = s.top();
                if (a == ']' && t == '[')
                {
                    s.pop();
                }
                else if (a == ')' && t == '(')
                {
                    s.pop();
                }
                else if (a == '}' && t == '{')
                {
                    s.pop();
                }
                else
                {
                    s.push(a);
                }
            }
        }

        return s.empty();
    }
};

// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            if (st.isEmpty() == true) {
                if (ch == '{' || ch == '[' || ch == '(') {
                    st.push(ch);
                }
                else {
                    return false;
                }
            }
            else {
                if (ch == '(' || ch == '[' || ch == '{') {
                    st.push(ch);
                }
                else if (ch == '}') {
                    if (st.peek() == '{')
                    {
                        st.pop();
                    }
                    else {
                        return false;
                    }
                }
                else if (ch == ']') {
                    if (st.peek() == '[')
                    {
                        st.pop();
                    }
                    else {
                        return false;
                    }
                }
                else if (ch == ')') {
                    if (st.peek() == '(')
                    {
                        st.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        if (st.isEmpty() == true) return true;
        return false;
    }
}

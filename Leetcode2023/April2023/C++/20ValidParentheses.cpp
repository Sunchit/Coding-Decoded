class Solution {
public:
    bool isValid(string s) {
        
        int n = s.length();
        stack<char> st;
        for(int i=0;i<n;i++)
        {
            if(s[i]=='(' or s[i]=='{' or s[i]=='[') st.push(s[i]);
            
            else
            {
                if(st.empty()) return false;
                if(s[i]==')')
                {
                    if(st.top()!='(') return false;
                    st.pop();
                }
                if(s[i]=='}')
                {
                    if(st.top()!='{') return false;
                    st.pop();
                }
                if(s[i]==']')
                {
                    if(st.top()!='[') return false;
                    st.pop();
                }
            }
        }
        return st.empty();
    }
};

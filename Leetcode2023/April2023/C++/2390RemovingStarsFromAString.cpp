class Solution {
public:
    string removeStars(string s) {
        
        int n = s.length();
        stack<char> st;
        for(int i=0;i<n;i++)
        {
            if(s[i]=='*') st.pop();
            else st.push(s[i]);
        }
        string ans;
        while(!st.empty()) {ans+=st.top(); st.pop();}
        reverse(ans.begin(), ans.end());
        return ans;
    }
};

class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        string temp="";
        int i=0;
        string ans="";
        while(i<s.length()/2){
            temp+=s[i++];
            if(s.length()%temp.length()) continue;
            int c=s.length()/temp.length();
            ans="";
            for(int i=0;i<c;i++) ans+=temp;
            // cout<<temp<<" "<<ans<<endl;
            if(ans==s && temp.length()!=s.length()) return true;
        }
        // cout<<temp<<endl;
        return false;

    }
};
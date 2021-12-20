class Solution {
public:
    string genString(string& s,int& i)
    {
        string res="";
        while(i<s.length() && s[i]!=']')
        {
            if(!isdigit(s[i]))
                res+=s[i++];
            else
            {
                int n=0;
                while(i<s.length() && isdigit(s[i]))
                    n=n*10+(s[i++]-'0');
                // cout<<s[i]<<endl;
    
                i++;
                string t=genString(s,i);
                // cout<<s[i];               
                i++;
                while(n-->0)
                    res+=t;
                // cout<<s[i];
            }
        }
        
        return res;
    }
    
    
    string decodeString(string s) {
        int i=0;
        return genString(s,i);
    }
};
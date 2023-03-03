class Solution {
public:
    int strStr(string s, string t) {
        
        int n = s.length(), m = t.length();
        for(int i=0;i<=n-m+1;i++)
        {
            int j=0;
            for(j=0;j<m;j++)
            {
                if(s[i+j]!=t[j]) break;
            }
            if(j==m) return i;
        }
        return -1;
        // return s.find(t);
    }
};

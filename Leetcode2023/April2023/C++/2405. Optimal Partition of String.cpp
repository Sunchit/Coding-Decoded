class Solution {
public:
    int partitionString(string s) {
        
        int n = s.length(), start = 0, ans = 1;
        vector<int> v(26, -1);
        
        for(int i=0;i<n;i++)
        {
            if(v[s[i]-'a']>=start)
            {
                ans++;
                start = i;
            }
            v[s[i]-'a'] = i;
        }
        return ans;
    }
};

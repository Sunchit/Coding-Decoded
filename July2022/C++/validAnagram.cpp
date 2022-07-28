class Solution {
public:
    bool isAnagram(string s, string t) {
        
        vector<int>hash(256);
       if(s.length()!=t.length()) return false;
        
        for(int i=0;i<s.length();i++)
        {
            hash[s[i]]++;
        }
        
        for(int i=0;i<t.length();i++)
        {
             hash[t[i]]--;
        }
        
        for(int i=0;i<256;i++)
        {
            if(hash[i]!=0) return false;
        }
        return true;
    }
};

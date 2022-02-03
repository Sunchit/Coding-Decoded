class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if(s.length()<p.length()) return {};
        vector<int> dict(26,0);
        vector<int> res;
        for(auto& i:p) dict[i-'a']++;
        int valid=0,start=0,end=p.length()-1;
        for(int i=start;i<=end;i++)
        {
            if(dict[s[i]-'a']>0)  valid++;
            dict[s[i]-'a']--;
        }
        
        if(valid==p.length()) res.push_back(0);
        end++;
        while(end<s.length())
        {
            
            if(dict[s[start]-'a']>=0) valid=--valid<0?0:valid;
            dict[s[start]-'a']++;
            start++;
            if(dict[s[end]-'a']>0) valid++;
            dict[s[end]-'a']--;
            if(valid==p.length()) res.push_back(start);
            end++;
        }
        return res;
    }
};
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.length()>s2.length()) return false;
        int n=s1.length(),m=s2.length();
        vector<int> dict(26,0);
        for(int i=0;i<n;i++)
        {
            dict[s1[i]-'a']++;
            dict[s2[i]-'a']--;
        }
        if(allzeroes(dict)) return true;
        
        for(int i=n;i<m;i++)
        {
            dict[s2[i]-'a']--;
            dict[s2[i-n]-'a']++;
            if(allzeroes(dict)) return true;
        }
        return false;
    }
    
    bool allzeroes(vector<int>& dict)
    {
        for(auto& i:dict) if(i)return false;
        return true;
    }
};
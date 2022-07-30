class Solution {
    private:
    vector<int> solve(string &s)
    {
        vector<int> tmp(26);
        for(int i=0;i<s.length();i++) tmp[s[i]-'a']++;
        return tmp;
    }
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<string> ans;
        vector<int> counter(26),tmp(26);
        
        for(auto &it:words2)
        {
            tmp = solve(it);
            for(int i=0;i<26;i++)
            {
                counter[i] = max(counter[i],tmp[i]);
            }
        }
        
        for(auto &it:words1)
        {
            int f = 0;
            tmp = solve(it);
            for(int i=0;i<26;i++)
            {
                if(tmp[i]<counter[i]) {f = 1;break;}
            }
            if(f == 0) ans.push_back(it);
        }
        return ans;
    }
};

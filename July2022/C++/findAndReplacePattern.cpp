class Solution {
    private:
    bool check(string &w, string &p)
    {
        unordered_map<char,char> m1,m2;
        
        for(int i=0;i<w.length();i++)
        {
            if((m1.count(w[i]) and m1[w[i]] != p[i])
              or (m2.count(p[i]) and m2[p[i]] != w[i]))
                return false;
            
            else 
            {
                m1[w[i]] = p[i];
                m2[p[i]] = w[i];
            }
        }
        return true;
    }
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        vector<string> ans;
        for(auto &w:words)
        {
            if(check(w,pattern)) ans.push_back(w);
        }
        return ans;
        
}
};

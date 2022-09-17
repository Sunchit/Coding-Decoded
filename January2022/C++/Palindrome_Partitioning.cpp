class Solution {
    vector<vector<string>> res;
    public:
    vector<vector<string>> partition(string s) {
        vector<string> temp;
        dfs(s,0,temp);
        return res;
    }
    void dfs(string& s,int idx,vector<string>& temp)
    {
        if(idx==s.length())
            res.push_back(temp);
        
        for(int i=idx;i<s.length();i++)
        {
            if(ispalindrome(idx,i,s))
            {
                temp.push_back(s.substr(idx,i-idx+1));
                dfs(s,i+1,temp);
                temp.pop_back();
            }
        }
    }
    bool ispalindrome(int start ,int end ,string& s)
    {
        while(start<=end && s[start]==s[end])
        {
            start++;
            end--;
        }
        return start>end;
    }
};
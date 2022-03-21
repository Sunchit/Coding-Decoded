class Solution {
public:
    vector<int> partitionLabels(string s) {
        vector<int> idx(26,-1);
        for(int i=0;i<s.length();i++) idx[s[i]-'a']=i;
        int start=0,end=0;
        vector<int> res;
        for(int i=0;i<s.length();i++)
        {
            end=max(end,idx[s[i]-'a']);
            if(i==end)
            {
                res.push_back(end-start+1);
                start=end+1;
            }
        }
        
        return res;
    }
};
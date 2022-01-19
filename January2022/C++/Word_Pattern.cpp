class Solution {
public:
    bool wordPattern(string pattern, string s) {
        stringstream str(s);
        string temp;
        int i=0;
        vector<string> dict(26,"");
        unordered_map<string,int> revdict;
        while(i<pattern.length() && !str.eof())
        {
            
           str>>temp; 
           int idx=pattern[i]-'a';
           if((!dict[idx].empty() && dict[idx]!=temp )|| (revdict.count(temp) && revdict[temp]!=idx)) return false;
            
            dict[idx]=temp;
            revdict[temp]=idx;
            i++;
        }
               
        return str.eof() && i==pattern.length()?true:false;
    }
};
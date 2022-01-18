class Solution {
public:
    vector<string> makeArray(string s){
         vector<string> temp;
        for(int i=0,n=s.size();i<n;i++){
            string x;
        while(s[i]!=' '&&i<n){
            x+=s[i];
            i++;
        }
        temp.push_back(x);
        }
        return temp;
    }
    
    bool wordPattern(string p, string s) {
        vector<pair<bool,string>> temp(26,make_pair(false,"-1"));
        vector<string> str = makeArray(s);
        if(str.size()!=p.size())
            return false;
        set<string> x;
        set<char>y;
        
        for(int i=0;i<p.size();i++){
            y.insert(p[i]);
            x.insert(str[i]);
            temp[p[i]-'a'].first=true;
            if(temp[p[i]-'a'].second=="-1")
                temp[p[i]-'a'].second=str[i];
            else if(temp[p[i]-'a'].second!=str[i])
                return false;
        }
        return x.size()==y.size();
    }
};
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
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

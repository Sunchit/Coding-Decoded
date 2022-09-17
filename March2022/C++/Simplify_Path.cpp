class Solution {
public:
    string simplifyPath(string path) {
        vector<string> value;
        stringstream stream(path);
        string res;
        while(getline(stream,path,'/'))
        {
            if(path=="" || path==".") continue;
            else if(path=="..") { if(value.size()) value.pop_back();}
            else value.push_back(path);
        }
        
        for(auto& i:value) res+=("/"+i);
        return res.length()>1?res:"/";
    }
};
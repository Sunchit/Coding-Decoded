class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
    string temp;
        int n  = s.size();
        vector<string> ans;
        for(int i=0;i<n;){
            temp="";
            for(int j=0;j<k&&i<n;j++,i++)
                temp+=s[i];
            while(temp.size()<k)
            temp+=fill;
            ans.push_back(temp);
        }
        return ans;

        
    }
};

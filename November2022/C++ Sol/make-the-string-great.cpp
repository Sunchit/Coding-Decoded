// @Sarang661
class Solution {
public:
    string makeGood(string s) {
        
        string ans;
        
        for(int i = 0 ; i < s.size() ; i++)
        {
            ans.push_back(s[i]);
            
            while(ans.size() && (ans.back()==s[i+1]+32 || ans.back()==s[i+1]-32))
            {
                ans.pop_back();
                i++;
            }
        }
        
        return ans;
    }
};
// @Sarang661
class Solution {
public:
    string orderlyQueue(string s, int k) {
        if(k==0){
            return s;
        }
        string ans = s;
        int n = s.size();
        if(k==1){
            for(int i=0;i<s.size();i++){
                 string curr = s.substr(i+1,n-(i+1)) + s.substr(0,i+1);
                 ans = min(ans,curr);
            }
            return ans;
        }
        else{
            sort(s.begin(),s.end());
            return s;
        }
    }
};
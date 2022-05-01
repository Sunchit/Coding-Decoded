class Solution {
public:
    bool backspaceCompare(string s, string t) {
         int sn = s.size();
        int tn = t.size();
        
        string st="",tt="";
        int cnt = 0;
        for(int i = sn - 1; i>=0; i--){
            if(s[i] == '#')
            {
                cnt++;
            }
            else if(cnt == 0){
                st += s[i];
                
            }
            else{
                cnt--;
            }
           
        }
        cnt = 0;
        for(int i =tn - 1; i>= 0; i--){
            if(t[i] == '#')
            {
                cnt++;
            }
            else if(cnt == 0){
                tt += t[i];
                
            }
            else{
                cnt--;
            }
           
        }
      //  cout<<st<<tt;
        return st == tt;
    }
};

// @Sarang661
class Solution {
public:
    string removeDuplicates(string s) {

        stack<char>removeDup;
        int total_size = s.size();

        for(int index = 0; index < total_size; index++){
            bool flag = false;
            while(removeDup.size()>0 && removeDup.top()==s[index] ){
                flag = true;
                removeDup.pop();
            }
            if(flag==false){
                removeDup.push(s[index]);
            }

        }
        string ans = "";
        while(removeDup.empty()==false){
            ans+=removeDup.top();
            removeDup.pop();
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};
class Solution {
public:
    string reverseWords(string s) {
        int n = s.size();
        reverse(s.begin(),s.end());
        int curr = 0;
        int i = 0;
            int start = 0;
        while(i<n){
            if(s[i]!=' '){
            
                while(i<n && s[i]!=' '){
                    s[curr]= s[i];
                    curr++;
                    i++;
                }
                s[curr] = ' ';
                // cout<<start<<" "<<curr<<" "<<s<<"\n";
                reverse(s.begin()+start,s.begin()+curr);
                curr++;
                start = curr;
            }
            i++;
        }


        s.erase(curr-1,s.size()-curr+1);
        return s;
    }
};
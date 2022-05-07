class Solution {
public:
    string removeDuplicates(string s, int k) {
        stack<pair<char,int>> st;
        int n = s.size();
        for(int i=0;i<n;i++){
            if(st.empty() || st.top().first != s[i]){
                st.push({s[i], 1});
            }
            else{
                auto x = st.top();
                    st.pop();
                    if(x.second + 1 != k){
                        st.push({x.first, x.second +1});
                    }
                
              
            }
        }
        // cout<<st.size();
        string ans = "";
        while(!st.empty()){
            auto p = st.top();
             st.pop();
            char ch = p.first;
            int freq = p.second;
           
            for(int i=0;i<freq;i++)
                ans += ch;  // if you are facing memory error then you just have to add  "+=" for adding string then you code will work(i dont know why but it works but not with ans = ans + ch) 
            
        }
        
        reverse(ans.begin(),ans.end());
        return ans;
    }
};



class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>>ans;
        vector<string>temp;
        dfs(s,ans,temp);
        return ans;
    }
    void dfs(string &s,vector<vector<string>>&ans,vector<string>&temp){
        int n = s.size();
        if(n == 0){
            ans.push_back(temp);
            return;
        }
        for(int i=0;i<s.size();i++){
            string firstpart = s.substr(0,i+1);
            if(is_pal(firstpart)){
                temp.push_back(firstpart);
                string second = s.substr(i+1,n);
                dfs(second,ans,temp);
                temp.pop_back(); //backtracking part       
            }
        }
    }
  //checking palindrome or not 
    bool is_pal(string str){
        return str == reverse(str.begin(),str.end());
        int start = 0;
        int end = str.size()-1;
        while(start<=end)
        {
            if(str[start]!=str[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
};

//Problem Link : https://leetcode.com/problems/valid-palindrome-ii/
class Solution {
public:
    bool utility(string& s, int cnt,int l,int r){
       
    
        if(l>r || l == r){
            return true;
        }
        else if(s[l] == s[r]){
        
            return utility(s,cnt,l+1,r-1);
        }
        else if (cnt >= 1){
           
            return false;
        }
        else{
         
            return utility(s,cnt+1,l+1,r) || utility(s,cnt+1,l,r-1);
        }
    }
    bool validPalindrome(string s) {
        
        return utility(s,0,0,s.size() - 1);
    }
};

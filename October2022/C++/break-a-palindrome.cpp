//https://leetcode.com/problems/break-a-palindrome/
// TC O(N)
//SC O(1)
class Solution {
public:
    string breakPalindrome(string palindrome) {
        bool flag = false;
        int len = palindrome.size();
        if(len==1){
            return "";
        }
   
     // will replace first character with 'a' which is not in the middle
        for(int i=0;i<len;i++){
            if(len%2==1 && i==(len/2)){
             
                continue;
            }
            if(palindrome[i]!='a'){
                palindrome[i]='a';
                flag = true;
                break;
            }
        }
        // if all characters are 'a' or middle character is not equal to 'a'
        if(flag==false){
            palindrome[len-1]='b';
        }

        
        return palindrome;
    }
};
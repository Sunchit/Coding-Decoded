// @Sarang661
class Solution {
public:
    int longestPalindrome(vector<string>& words) {\
        
        
        bool flag = false;
        int total_size = words.size();
        int total_palindromeLen = 0;
        
        map<string,int>prevS;
        
        
        for(int index = 0 ; index < total_size; index++){
            string curr = words[index];
            reverse(curr.begin(),curr.end());
            
            if(prevS.find(curr)!= prevS.end()){
                prevS[curr]--;
                if(prevS[curr]==0){
                    prevS.erase(curr);
                }
                total_palindromeLen += (4);
            }
            else{
                prevS[words[index]]++;
            }
        }
            
                                                  
        for(auto str:prevS){
            if(str.first[0] == str.first[1] && flag== false){
                total_palindromeLen += 2;
                flag = true;
            }
        }
                                                  
                    return total_palindromeLen;
    }
};
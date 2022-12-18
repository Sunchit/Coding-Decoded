class Solution {
private:
  
public:
    int longestCommonSubsequence(string text1, string text2) {
        
        int len1 = text1.size();
        int len2 = text2.size();
        
       vector<int>prev(len2+1, 0);
       vector<int>curr(len2+1, 0);
        
        for(int i=1; i <= len1; i++){
            
            for(int j = 1; j <= len2; j++){
                
                if(text1[i-1] == text2[j-1]){
                    
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = max( prev[j], curr[j-1] );
                }
            }
            
            prev = curr;
        }
        
       
        
        
        
        return curr[len2];
    }
};
// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun validPalindrome(s: String): Boolean {
        var i:Int=0;
        var j:Int=s.length-1;
        while(i<j){
            if(s[i]==s[j]){
                i++;
                j--;
            }else{
                return (checkP(s.substring(i+1,j+1)) or checkP(s.substring(i,j)));
            }
        }
        
        return true;
    }
    
    fun checkP(s: String): Boolean{
        var i:Int=0;
        var j:Int=s.length-1;
        while(i<j){
            if(s[i]==s[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }
        
        return true;
    }
}
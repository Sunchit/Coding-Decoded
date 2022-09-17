//Author Shobhit Behl (LC : shobhitbruh)
class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var p=0;
        if(p==s.length)return true;
        for(i in 0..t.length-1){
            if(t[i]==s[p]){
                p++;
            }
            if(p==s.length){
                return true;
            }
        }
        
        return false;
    }
}
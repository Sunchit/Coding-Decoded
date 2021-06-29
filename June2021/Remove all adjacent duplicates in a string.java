/*
 * @author : Darshika Jha
 * Question Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
*/
class Solution {
    public String removeDuplicates(String s) {
        
        for(int i = 1;i<s.length();i++){
            if(i<1){
                continue;
            }
            if(s.charAt(i)==s.charAt(i-1)){
                s = s.substring(0,i-1)+s.substring(i+1);
                i = (i-2)<0?0:i-2;
            }
        }
        
        return s;
    }
}

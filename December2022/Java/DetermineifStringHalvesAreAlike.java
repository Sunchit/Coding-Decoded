// Problem Link: https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
// @author: Mahesh Reddy B N
/*
 * TC: O(n)
 * SC: O(1)
 */
class Solution {
    public boolean halvesAreAlike(String s) {
        int fcount = 0,lcount = 0;
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(i<s.length()/2){
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    fcount++;
                }
            }
            else{
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    lcount++;
                }
            }
        }
        if(fcount == lcount) return true;
        return false;
    }
}
// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1=new Stack<>();
        Stack<Character> st2=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(st1.size()>0){
                st1.pop();
                }
            }else{
                st1.push(s.charAt(i));
            }
        }
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if(st2.size()>0){
                st2.pop();
                }
            }else{
                st2.push(t.charAt(i));
            }
        }
        
        return st1.equals(st2);
    }
}


// @saorav21994
// TC : O(n)
// SC : O(1)
// Follow up solution with O(1) space 


class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        StringBuffer sb = new StringBuffer("");
        int back = 0;
        for (int i = sl-1; i >= 0; i--) {
            if (s.charAt(i) == '#')
                back += 1;
            else {
                if (back > 0) {
                    back -= 1;
                    continue;
                }
                sb.insert(0, s.charAt(i));
            }
        }
        
        back = 0;
        int j = sb.length();
        
        for (int i = tl-1; i >= 0; i--) {
            if (t.charAt(i) == '#') {
                back += 1;
            }
            else {
                if (back > 0) {
                    back -= 1;
                    continue;
                }
                j -= 1;
                if (j >= 0) {
                    if (t.charAt(i) != sb.charAt(j))
                        return false;
                }
            }
        }
        
        if (j != 0)
            return false;
        
        return true;
    } 
}

// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public void reverseString(char[] s) {
        StringBuilder sb=new StringBuilder();
        for(char x:s){
            sb.append(x);
        }
        char[] y=sb.reverse().toString().toCharArray();
        for(int i=0;i<s.length;i++){
            s[i]=y[i];
        }
    }
}
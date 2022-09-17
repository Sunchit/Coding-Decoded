// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int minBitFlips(int start, int goal) {
        String a1=Integer.toBinaryString(start);
        String a2=Integer.toBinaryString(goal);
        int x=32-a2.length();
        int y=32-a1.length();
        while(x-->0){
            a2='0'+a2;
        }
         while(y-->0){
            a1='0'+a1;
        }
        char[] p=a1.toCharArray();
        char[] q=a2.toCharArray();
        int c=0;
        for(int i=0;i<p.length;i++){
            if(p[i]!=q[i]){
                c++;
            }
        }
        
        return c;
    }
}
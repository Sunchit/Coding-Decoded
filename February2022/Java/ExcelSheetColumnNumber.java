//Author : Shobhit Behl (LC:shobhitbruh)
class Solution {
    public int titleToNumber(String a) {
        char[] b=a.toCharArray();
        int ans=0;
        int p=0;
        for(int i=b.length-1;i>=0;i--){
            ans+=(pow(p)*(b[i]-'A'+1));
            p++;
        }
        
        return ans;
    }
    
    public int pow(int p){
        int i=1;
        while(p-->0){
            i*=26;
        }
        return i;
    }
}
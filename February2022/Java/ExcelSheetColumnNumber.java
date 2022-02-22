
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


// @saorav21994
// TC = O(numberOfDigits)
// SC = O(1)  


class Solution {
    public int titleToNumber(String columnTitle) {
        char [] ch = columnTitle.toCharArray();
        int l = ch.length;
        int itr = 0, res = 0;
        for (int i = l-1; i >= 0; i--) {
            res += (int)Math.pow(26,itr)*(ch[i]-'A'+1);
            itr += 1;
        }
        return res;
    }
}


// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public long numberOfWays(String s) {
        char[] arr=s.toCharArray();
        long[] dp=new long[s.length()];
        long[] a=new long[s.length()];
        long[] b=new long[s.length()];
        long[] c=new long[s.length()];
        long[] d=new long[s.length()];
        for(int i=s.length()-1;i>=0;i--){
            if(i+1<s.length()){
            c[i]+=c[i+1];
            d[i]+=d[i+1];
            a[i]+=a[i+1];
            b[i]+=b[i+1];
            dp[i]+=dp[i+1];
            }
            
            if(arr[i]=='0'){
                c[i]++;
                if(i+1<s.length()){
                a[i]+=d[i+1];
                dp[i]+=b[i+1];    
                }
                
            }else{
                d[i]++;
                if(i+1<s.length()){
                b[i]+=c[i+1];
                dp[i]+=a[i+1];    
                }
            }
            
        }
        
        return dp[0];
        
    }
}
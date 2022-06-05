// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int numberOfSteps(int num) {
        String b=Integer.toBinaryString(num);
        char[] a=b.toCharArray();
        int ans=0;
        for(int i=0;i<a.length;i++){
            if(i==0&&a[i]=='1'){
                ans++;
            }else if(i>0){
                if(a[i]=='0'){
                    ans++;
                }else{
                    ans+=2;
                }
            }
        }
        
        return ans;
    }
}
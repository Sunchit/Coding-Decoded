// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public String minimizeResult(String e) {
        int k=0;
        for(int i=0;i<e.length();i++){
            if(e.charAt(i)=='+'){
                k=i;
                break;
            }
        }
        int m=Integer.MAX_VALUE;
        String ans="";
        for(int i=0;i<k;i++){
            for(int j=e.length();j>k;j--){
                String a=e.substring(0,i)+"("+e.substring(i,k);
                int p=1;
                if(e.substring(0,i).length()>0){
                    p=Integer.parseInt(e.substring(0,i));
                }
                int q=0;
                if(e.substring(i,k).length()>0){
                    q=Integer.parseInt(e.substring(i,k));
                }else{
                    continue;
                }
                String b=e.substring(k+1,j)+")"+e.substring(j,e.length());
                int r=0;
                if(e.substring(k+1,j).length()>0){
                    r=Integer.parseInt(e.substring(k+1,j));
                }else{
                    continue;
                }
                int s=1;
                if(e.substring(j,e.length()).length()>0){
                    s=Integer.parseInt(e.substring(j,e.length()));
                }
                
                // System.out.println(a+"+"+b);
                
                int res=(p*s*(q+r));
                // System.out.println(i+" "+j+" "+res+" "+(a+"+"+b)+" --");
                if(res<m){
                    // System.out.println(res+" "+m+" "+ans+" "+(a+"+"+b));
                    m=res;
                    ans=a+"+"+b;
                }
            }
            
        }
        
        return ans;
    }
    
   
}

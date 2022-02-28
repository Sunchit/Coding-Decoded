//Author : Shobhit Behl (LC : shobhitbruh)
class Solution {
    public List<String> summaryRanges(int[] arr) {
        List<String> ans=new ArrayList<>();
        if(arr.length==0){
            return ans;
        }
        
        int i=0,j=0;
        while(i<arr.length){
            if(arr[i]-arr[j]!=i-j){
                StringBuilder sb=new StringBuilder();
                if(i-1==j){
                    sb.append(arr[j]);
                    ans.add(sb.toString());
                }else{
                    sb.append(arr[j]+"->"+arr[i-1]);
                    ans.add(sb.toString());
                }
                j=i;
            }
            i++;
        }
        StringBuilder sb=new StringBuilder();
       if(i-1==j){
                    sb.append(arr[j]);
                    ans.add(sb.toString());
                }else{
                    sb.append(arr[j]+"->"+arr[i-1]);
                    ans.add(sb.toString());
                }
        return ans;
    }
}
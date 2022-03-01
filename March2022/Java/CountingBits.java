//Author : Shobhit Behl (LC : shobhitbruh)
class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<arr.length;i++){
            int j=i;
            int c=0;
            while(j>0){
                c++;
                j^=(j&(~j+1));
            }
            
            arr[i]=c;
        }
        
        return arr;
    }
}
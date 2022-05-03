// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        boolean[] a=new boolean[nums.length];
        Arrays.fill(a,true);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=nums[i]){
                a[i]=false;
            }
        }
        int st=-1;
        int en=-1;
        for(int i=0;i<a.length;i++){
            if(!a[i]){
                if(st==-1){
                    st=i;
                }
                en=i;
            }
        }
        
        if(st==-1&&en==-1){
            return 0;
        }
        
        return en-st+1;
    }
}
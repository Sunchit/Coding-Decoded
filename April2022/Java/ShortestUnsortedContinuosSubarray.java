// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int st=-1;
        int en=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=nums[i]){
                st=i;
                break;
            }
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]!=nums[i]){
                en=i;
                break;
            }
        }
        
        
        if(st==-1&&en==-1){
            return 0;
        }
        
        return en-st+1;
    }
}
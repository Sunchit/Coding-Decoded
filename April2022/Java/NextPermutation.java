// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public void nextPermutation(int[] nums) {
        ArrayList<Integer> x=new ArrayList<>();
        int p=0;
        int q=0;
       for(int i=nums.length-2;i>=0;i--){
           if(nums[i]<nums[i+1]){
              p=i;
              q++;
               break;
           }
       }
        if(q==0){
            Arrays.sort(nums);
            return;
        }
       int z=Integer.MAX_VALUE;
        int idx=-1;
       for(int i=nums.length-1;i>p;i--){
           if(nums[i]<z&&nums[p]<nums[i]){
               z=nums[i];
               idx=i;
           }
       }
       if(idx!=-1){
           int temp=nums[p];
           nums[p]=nums[idx];
           nums[idx]=temp;
           for(int i=nums.length-1;i>p;i--){
          x.add(nums[i]);
           }
           Collections.sort(x);
           int j=0;
           for(int i=p+1;i<nums.length;i++){
               nums[i]=x.get(j);
               j++;
           }
        }
        
        
    }
}
// Author : Shobhit Behl(shobhitbruh)
// T:O(N) 100% faster solution 
class Solution {
    public int removeDuplicates(int[] nums) {
        int ans=0;
        int j=0;
        int f=0;
        int l=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==l&&f==2){
                continue;
            }else{
                if(nums[i]!=l)f=0;
                nums[j]=nums[i];
                f++;
                l=nums[i];
                ans++;
                j++;
            }
        }
        
        return ans;
    }
}
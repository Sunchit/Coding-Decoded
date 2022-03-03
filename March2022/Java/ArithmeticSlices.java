// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Integer,HashSet<Integer>> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                HashSet<Integer> hs=new HashSet<>();
                hs.add(i);
                hm.put(nums[i],hs);
            }else{
                hm.get(nums[i]).add(i);
            }
        }
        int c=0;
        for(int i=2;i<nums.length;i++){
            int d=nums[i]-nums[i-1];
            int k=2;
            while(i-k>=0&&hm.containsKey(nums[i]-(k*d))&&hm.get(nums[i]-(k*d)).contains(i-k)){
                c++;
                k++;
            }
        }
        
        return c;
    }
}
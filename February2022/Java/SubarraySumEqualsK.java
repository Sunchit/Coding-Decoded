class Solution {
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(0,1);
        int c=0;
        int[] ts=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ts[i]=nums[i];
            if(i>0){
                ts[i]+=ts[i-1];
            }
            
            if(hs.containsKey(ts[i]-k)){
                c+=hs.get(ts[i]-k);
            }
            
            hs.put(ts[i],hs.getOrDefault(ts[i],0)+1);
        }
        
        return c;
    }
}
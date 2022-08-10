// https://leetcode.com/problems/count-number-of-bad-pairs/
// @author: anuj0503
class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long count = 0;
        
        for(int i = 0; i < nums.length; i++){
            nums[i] -= i;
        }
        
        
        Map<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(nums[i], 0L);
            long c = map.get(nums[i]);
            
            map.put(nums[i], c+1);
        }
        
        
        for(Map.Entry<Integer, Long> entry : map.entrySet()){
            long val = entry.getValue();
            if(val >= 2){
                
                count += ((val * (val - 1))/2);
            }
        }
        
        long size = nums.length;
        
        return (size * (size - 1))/2 - count;
    }
}

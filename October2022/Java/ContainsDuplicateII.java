
// @saorav21994

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer pos = map.get(nums[i]);
            if (pos != null && i-pos <= k)
                return true;
            else
                map.put(nums[i], i);
        }
        
        return false;
    }
}

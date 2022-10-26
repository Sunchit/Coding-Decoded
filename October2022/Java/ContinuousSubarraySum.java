// @saorav21994

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // as stated , 0 is multiple of all k
        map.put(0,0);
        
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            // if sum % k occurs for the first time
            if (!map.containsKey(sum % k))
                map.put(sum % k, i + 1);
            // at least 2 indices should make up the sum
            else if (i-map.get(sum % k) >= 1)
                return true;
        }
        return false;
    }
}

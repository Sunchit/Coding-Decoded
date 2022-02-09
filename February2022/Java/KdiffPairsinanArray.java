
// @saorav21994
// TC:  O(n)
// Medium

/*
  Similar approach as sum of 2 nummber to a given sum in an array. Special case of (k == 0) -> check for frequency of the number >= 2 as only (x-x) will give 0.
*/


class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
        	map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int pairs = 0;
        
        for (Integer key : map.keySet()) {
        	int mapVal = map.getOrDefault(key+k, 0);
            if (k == 0) {
                if (mapVal > 1)
                    pairs += 1;
            }
            else {
                if (mapVal > 0)
                    pairs += 1;
            }
        	
        }
        
        return pairs;
        
    }
}

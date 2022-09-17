
// @saorav21994
// TC : O(n)
// SC : O(n)
// It can be done in 2-pointer approach but then we need to sort the array -> TC : O(nlogn), SC : O(1). I have prioritized time over space.

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (int i : nums) {
            if (map.containsKey(k-i)) {
                if (i == (k-i)) {
                    res += map.get(i)/2;
                    map.remove(i);
                }
                else {
                    res += Math.min(map.get(i), map.get(k-i));
                    map.remove(i);
                    map.remove(k-i);
                }
            }
        }
        return res;
    }
}

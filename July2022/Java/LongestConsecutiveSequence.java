
// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : nums) {
            if (set.contains(n-1) == true) continue;
            int cur = 1;
            int next = n+1;
            while (set.contains(next) == true) {
                cur += 1;
                next += 1;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}

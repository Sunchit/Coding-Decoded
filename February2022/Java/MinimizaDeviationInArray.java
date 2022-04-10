
// @saorav21994
// TreeSet in java gives sorted set (deafult : ascending)

// Solved it last year (JAN 2021) using this blogpost  - https://leetcode.com/problems/minimize-deviation-in-array/discuss/1781709/C%2B%2B-oror-Easy-oror-2-Approaches-oror-Priority-Queue-oror-Set

class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            if (i%2 == 0) {
                set.add(i);
            }
            else {
                set.add(i*2);
            }
        }
        int res = Integer.MAX_VALUE;
        while (true) {
            int min = set.first();
            int max = set.last();
            res = Math.min(res, max-min);
            if (max%2 == 0) {
                set.remove(max);
                set.add(max/2);
            }
            else 
                return res;
        }
    }
}

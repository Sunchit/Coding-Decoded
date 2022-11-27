// @saorav21994

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int res = 0;
        HashMap<Integer, Integer> map[] = new HashMap[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long ldiff = (long)nums[i] - (long)nums[j];
                if (ldiff < Integer.MIN_VALUE || ldiff > Integer.MAX_VALUE)
                    continue;
                int diff = (int)ldiff;
                int cur = map[j].getOrDefault(diff, 0);
                int parent = map[i].getOrDefault(diff, 0);
                map[i].put(diff, cur + parent + 1);
                res += cur;
            }
        }
        return res;
    }
}

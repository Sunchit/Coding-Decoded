
// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public int candy(int[] ratings) {
        int l = ratings.length;
        int res = 0;
        int [] can = new int[l];
        Arrays.fill(can , 1);
        for (int i = 1; i < l; i++) {
            if (ratings[i] > ratings[i-1]) {
                can[i] = can[i-1] + 1;
            }
        }
        res += can[l-1];
        for (int i = l-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                can[i] = Math.max(can[i], can[i+1] + 1);
            }
            res += can[i];
        }
        return res;
    }
}

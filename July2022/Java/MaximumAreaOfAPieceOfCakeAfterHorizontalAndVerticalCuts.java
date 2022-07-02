
// @saorav21994
// TC : O(n)
// SC : O(1)

// Multiple companie(s) including Amazon ask this in online round.

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int hl = horizontalCuts.length;
        int vl = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxh = 0, maxv = 0;
        int prev = 0;
        for (int i = 0; i < hl; i++) {
            maxh = Math.max(maxh, horizontalCuts[i] - prev);
            prev = horizontalCuts[i];
        }
        maxh = Math.max(h-prev, maxh);
        // System.out.println("maxh = " + maxh);
        prev = 0;
        for (int i = 0; i < vl; i++) {
            maxv = Math.max(maxv, verticalCuts[i] - prev);
            prev = verticalCuts[i];
        }
        maxv = Math.max(w-prev, maxv);
        // System.out.println("maxv = " + maxv);
        long res = (long)((long)((long)maxh%1000000007 * (long)maxv%1000000007))%1000000007;
        return (int)res;
    }
}

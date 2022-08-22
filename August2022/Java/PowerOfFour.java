
// @saorav21994
// TC : O(log n base 4)
// SC : O(1)

class Solution {
    public boolean isPowerOfFour(int n) {
        double loggy = Math.log(n)/Math.log(4);
        int ilog = (int)loggy;
        loggy = Math.ceil(loggy);
        return (loggy==ilog);
    }
}

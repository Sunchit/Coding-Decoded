
// @saorav21994
// TC : O(logn)
// SC : O(1)
// Do not do n&(n-1), specially need to be taken care of since java do not have unsigned integer type.
// Alternative approach can be -> while (n > 0) { if (n&1) cnt++; n >>= 1; }

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}

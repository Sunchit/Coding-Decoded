
// @saorav21994
// TC : O(max value ^ 2)
// SC : O(max value)

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long [] count = new long[101];
        long res = 0L;
        int mod = 1000000007;
        for (int i : arr) 
            count[i]++;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target-i-j;
                if (k > 100 || k < 0) 
                    continue;
                else if (i == j && j == k) {
                    res += count[i] * (count[i]-1) * (count[i]-2) / 6;
                    res %= mod;
                }
                else if (i == j && j != k) {
                    res += count[i] * (count[i]-1) / 2 * count[k];
                    res %= mod;
                }
                else if (j < k) {
                    res += count[i] * count[j] * count[k];
                    res %= mod;
                }
            }
        }
        return (int)(res%mod);
    }
}

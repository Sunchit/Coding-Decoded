class Solution {
private:
    int getBinaryNumberLength(int n) {
         int length = 0;
         while (n > 0) {
             n /= 2;
             length++;
         }
         return length;
    }
    
public:
    // TC: O(nlogn)
    // SC: O(1)
    int concatenatedBinary(int n) {
        int MOD = (int) 1e9 + 7;

        long ans = 0;

        for (int i = 1; i <= n; i++) {
            int noOfShifts = getBinaryNumberLength(i);
            ans = (ans << noOfShifts) % MOD;
            ans += i;
            ans %= MOD;
        }

        return (int) ans % MOD;
    }
};

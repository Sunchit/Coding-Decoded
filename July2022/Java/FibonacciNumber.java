
// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int fib(int n) {
        int res = 0;
        int a = 0, b = 1;
        if (n == 1) return 1;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}

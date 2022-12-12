// @saorav21994

class Solution {
    public int climbStairs(int n) {
        // fibbonacci
        if (n == 1)
            return 1;
        else if (n == 2) 
            return 2;
        else {
            int res = 0;
            int a = 1, b = 2;
            n -= 2;
            while (n > 0) {
                res = a + b;
                a = b;
                b = res;
                n -= 1;
            }
            return res;
        }
    }
}

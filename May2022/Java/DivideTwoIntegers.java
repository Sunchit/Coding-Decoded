
// @saorav21994
// TC : O(logn)
// SC : O(1)

class Solution {
    public int divide(int dividend, int divisor) {
        
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        boolean sign = ((dividend >= 0) == (divisor >= 0));
        
        /*
        Math.abs(Integer.MIN_VALUE) should return +2147483648.
        In regular binary 2147483648 is represented as 1000 0000 0000 0000 0000 0000 0000 0000.
        However, when Java sees this, it will see that there is a most significant bit 1. And see that it is looking at a negative number. This is because java takes 'int' in two's complement. 
        Hence, Math.abs(-2147483648) = -2147483648. 
            
        Ref : https://stackoverflow.com/questions/13422259/how-are-integers-internally-represented-at-a-bit-level-in-java
        
        Since we are working with bits here, so algorithmically it's correct.
        */
        
        int dd = Math.abs(dividend);
        int ds = Math.abs(divisor);
        int res = 0;
        
        while (dd - ds >= 0) {
            int ctr = 0;
            while (dd - (ds << 1 << ctr) >= 0) {
                ctr += 1;
            }
            
            // how many times we doubled ctr
            res += (1 << ctr);
            
            dd -= (ds << ctr);
        }
        
        return (sign == true) ? res : -res;
        
    }
}

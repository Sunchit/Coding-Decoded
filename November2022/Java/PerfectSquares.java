// @saorav21994

class Solution {
    public int numSquares(int n) {
        // This is a mathematical question. Hence, using Legendre's theorem
        /* 
            Every natural number can be represented as sum of 3 perfect squares untill it is of the
            form 4^a * (8b+7) for which the result is 4
        */
        
        while (n%4 == 0) {
            n /= 4;
        }
        
        if (n%8 == 7)
            return 4;
        
        // check if the number is a perfect square
        int sq = (int)Math.sqrt(n);
        if (sq*sq == n)
            return 1;
        
        // for all other cases see if the number can be represented as sum of 2 perfect sq, else return 3
        for (int i = 1; i*i < n; i++) {
            int newval = n-(i*i);
            int sqc = (int)Math.sqrt(newval);
            if (sqc*sqc == newval) {
                return 2;
            }
        }
        return 3;
    }
}

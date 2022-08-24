
// @saorav21994
// TC : O(log n) -> max = 19 -> O(1)
// SC : O(1)

class Solution {
    public boolean isPowerOfThree(int n) {
        // taken form gfg
        // 3^19 is max within Integer.MAX_VALUE;
        if (n <= 0) return false;
        int max = (int)Math.pow(3, 19);
        if (max % n == 0) return true;
        return false;
    }
}



/*
    other way ->
    
    n == 3^x
    => log n = x . log 3
    => x = log n / log 3
    if x is an integer, then n is a power of 3
    
    
*/
    


// @saorav21994
// TC : O(n) -> 1 pass
// SC : O(n)

// divide the number and fetch it from precomputed array part and take into factor for odd / even. For odd on dividing by 2 we always lose '1' bit and on even on dividing by 2 we do lose '0' bit

class Solution {
    public int[] countBits(int n) {
        
        int [] res = new int[n+1];
        
        // By default int array initialised to zero, so res[0] = 0
        
        for (int i = 1; i <= n; i++) {
            res[i] = res[i/2] + (i%2);
        }
        
        return res;
        
    }
}


// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        // use counting sort
        
        int l = changed.length;
        if (l%2 != 0)
            return new int[0];
        
        int [] res = new int[l/2];
        int [] hash = new int[100001];      // max value of changed[i] = 10^5
        
        for (int ele : changed) {
            hash[ele] += 1;
        }
        
        int index = 0;
        int processed = 0;
        
        for (int i = 0; i < hash.length; i++) {
            int d = i << 1;
            while (hash[i] > 0 && d < hash.length && hash[d] > 0) {
                if (i == d) {       // special case of zero
                    if (hash[i] < 2)
                        return new int[0];
                }
                res[index++] = i;
                hash[i] -= 1;
                hash[d] -= 1;
                processed += 2;
            }
        }
        
        if (processed == changed.length)
            return res;
        return new int[0];
        
        
    }
}

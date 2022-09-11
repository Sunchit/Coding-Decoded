
// @saorav21994
// TC : O(nlogn)
// SC : O(1)

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        // sort the array by attacks ascending and defense descending
        Arrays.sort(properties, (a,b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));
        
        // now trsverse in reverse order, for defense only
        // we do not need to check for attack to be strictly greater as it is sorted in ascending way with defense descending (for same attack), so same attack with > defense will never come while traversign sorted array in reverse order (end to start)
        
        int l = properties.length;
        int max = properties[l-1][1];
        
        int res = 0;
        
        for (int i = l-2; i >= 0; i--) {
            if (properties[i][1] < max) {
                res += 1;
            }
            else {      // update the max as new max found
                max = properties[i][1];
            }
        }
        
        return res;
    }
}


// @saorav21994
// Refer :
// https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf
// TC : O(nlogn)
// SC : O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        // Sort ascending on basis of a[x] and for same a[x] sort descending on basis of b[x]
        Arrays.sort(envelopes, (a,b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));
        
        int [] heights = new int[envelopes.length];      // max number of piles can be envelopes.length
        
        int maxHeight = 0;
        
        for (int [] env : envelopes) {
            
            // Since 1st dimension is sorted ascending, go for 2nd dimension
            int cur = env[1];
            int index = Arrays.binarySearch(heights, 0, maxHeight, cur);
            if (index < 0) {
                index = -index - 1;         // for not found, binarySearch returns (-index-1)
            }
            if (maxHeight == index)
                maxHeight += 1;
            heights[index] = cur;            // maintain top of card
        }
        
        return maxHeight;
    }
}

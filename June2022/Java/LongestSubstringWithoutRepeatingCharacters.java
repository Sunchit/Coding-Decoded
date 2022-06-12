
// @saorav21994
// TC : O(n)
// SC : O(256) = O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0)
            return 0;
        
        int [] pos = new int[256];
        Arrays.fill(pos, -1);
        
        int l = s.length();
        int cur = 1, res = 1;
        int lastTag = 0;              // Last character position at which repetition was observed 
        pos[s.charAt(0)] = 0;
        
        for (int i = 1; i < l; i++) {
            char ch = s.charAt(i);
            if (pos[ch] != -1) {      // pre-occupied
                if (pos[ch] < lastTag) {        // meaning that this character has a duplicate but exists before the current window, so has to be ignored
                    cur += 1;
                    res = Math.max(res, cur);
                }
                else {
                    cur = i - pos[ch];
                    lastTag = pos[ch];
                }
                
            }
            else {
                cur += 1;
                res = Math.max(res, cur);
            }
            pos[ch] = i;
            // System.out.println("res = " + res + " cur = " + cur);
        }
        
        return res;
        
    }
}

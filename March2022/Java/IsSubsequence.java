// @saorav21994
// TC : O(length of t)
// SC : O(1)

class Solution {
    public boolean isSubsequence(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        
        int i = 0, j = 0;
        
        while (i < ls) {
            char chs = s.charAt(i);
            boolean match = false;
            while (j < lt && chs != t.charAt(j)) {
                j += 1;
            }
            
            if (j >= lt && i < ls)
                return false;
            j += 1;
            i += 1;
            
        }
        return true;
    }
}

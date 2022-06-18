
// @saorav21994
// TC : O(n^2)
// SC : O(1)

class Solution {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() == 0)
            return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);   // for odd centre -> rac[e]car
            int len2 = expandFromMiddle(s, i, i+1); // for even centre -> aab[]baa
            
            int len = Math.max(len1, len2);
            
            if (len > (end-start)) {
                start = i - ((len-1)/2);
                end = i + (len/2);
            }
            
        }

        return s.substring(start, end+1);

    }
    
    public int expandFromMiddle(String s, int left, int right) {
        
        if (left > right)
            return 0;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        
        return right-left-1;
        
    }
    
}

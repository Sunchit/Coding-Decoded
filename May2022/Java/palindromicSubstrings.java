
// @saorav21994
// TC : O(n^2)
// SC : O(1)
// Pretty standard algorithm, for each character extend to both side till it remains equal. Do it for each character twice - for even and odd length.

class Solution {
    
    class gCount {
        int count;
        
        public gCount() {
            count = 0;
        }
    }
    
    public int countSubstrings(String s) {
        gCount count = new gCount();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            palindromeCheck(s, i, i, count);    // odd length palindrome
            palindromeCheck(s, i, i+1, count);  // even length palindrome
        }
        return count.count;
    }
    
    public void palindromeCheck(String s, int left, int right, gCount count) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count.count += 1;
            left -= 1;
            right += 1;
        }
    }
}

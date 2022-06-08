// @saorav21994
// TC : O(n)
// SC : O(1)
// explained below

class Solution {
    public int removePalindromeSub(String s) {
        
        /* 
            We need to search for subsequence and not substring.
            Since only 2 characters (a, b), So all a's can be a subsequence (palindrome);
            all b's can be a subsequence (palindrome).
            So if the string is palindrome it can be removed in 1 go. Ans = 1.
            If string is not palindrome, so all a's and all b's. So Ans = 2.
        */
        
        StringBuffer sb = new StringBuffer(s);
        if (sb.reverse().toString().equals(s)) {
            return 1;
        }
        return 2;
        
    }
}

// @saorav21994

class Solution {
    public String breakPalindrome(String palindrome) {
        int l = palindrome.length();
        if (l == 1)
            return "";
        else {
            char [] ch = palindrome.toCharArray();
            for (int i = 0; i < l/2; i++) {
                if (ch[i] == ch[l-i-1]) {
                    if (ch[i] != 'a') {
                        ch[i] = 'a';
                        return new String(ch);
                    }
                    
                }
            }
            ch[l-1] = 'b';
            return new String(ch);
        }
    }
}

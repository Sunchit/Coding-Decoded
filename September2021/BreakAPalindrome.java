class Solution {


    public String breakPalindrome(String palindrome) {
        char[] cStr = palindrome.toCharArray();
        // a
        if(cStr.length<2){
            return "";
        }


        for (int i = 0; i <cStr.length / 2; i++) {
            if (cStr[i] != 'a') {
                cStr[i] = 'a';
                return String.valueOf(cStr);
            }
        }
        // crossed middle point all ones
        cStr[cStr.length - 1] = 'b'; //if all 'a'
        return String.valueOf(cStr);
    }
}
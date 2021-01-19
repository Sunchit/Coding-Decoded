//TC: O(n2) SC: O(1)
class Solution {

    int maxLenLPS = 0;
    int startingPoint =0;



    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }

        for(int i=0;i<s.length();i++){
            checkForLongestPalindromicString(s, i, i); // odd length palindromic substring
            checkForLongestPalindromicString(s, i, i+1); // even length palindromic substring
        }

        return s.substring(startingPoint, maxLenLPS+startingPoint);
    }

    private void checkForLongestPalindromicString(String s, int left, int right){
        while(left>=0&& right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        if(maxLenLPS< right-left -1){
            maxLenLPS = right -left-1;
            startingPoint = left+1;
        }
    }
}
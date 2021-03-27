class Solution {
    // TC : O(2*O(n2))

    // SC : O(1)
    public int countSubstrings(String s) {

        int totalCount = 0;
        for(int i=0;i<s.length();i++){
            totalCount += getCountOfPalindromicSubstring(i,i, s);   // aba

            totalCount += getCountOfPalindromicSubstring(i,i+1, s); // abba

        }

        return totalCount;
    }

    private int getCountOfPalindromicSubstring(int start, int end, String s ){
        int tCount = 0;
        // O(n)
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            tCount++;
        }

        return tCount;
    }


}
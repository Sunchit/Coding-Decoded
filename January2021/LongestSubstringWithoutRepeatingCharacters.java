class Solution {

    // TC O(n)
    // SC O(1)
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int i =0;
        int[] freq =new int[256];
        int maxLen = 0;

        while(i<s.length()){
            int iIndex = s.charAt(i);
            freq[iIndex]++;

            while(freq[iIndex]>1){
                int sIndex = s.charAt(start);
                freq[sIndex]--;
                start++;
            }

            int currLen = i - start +1;
            maxLen = Math.max(currLen, maxLen);
            i++;
        }
        return maxLen;

    }
}

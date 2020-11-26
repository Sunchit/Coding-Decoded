// TC -> O(N2)
// SC -> 26 *O(N)
class Longest SubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int freq[] = new int[26];
        char[] str = s.toCharArray();
        for(char c: str){
            int index =c -'a';
            freq[index]++;
        }

        boolean valid = true;

        int start =0;
        int maxLen = 0;
        for(int end = 0;end<s.length();end++) {
            // TC -> O(N2)
            if(freq[str[end] - 'a'] >0 && freq[str[end] - 'a'] <k ){
                String subString = s.substring(start, end);
                maxLen  = Math.max(maxLen , longestSubstring(subString, k));
                start = end+1;
                valid = false;
            }
        }

        if(valid){
            return s.length();
        } else{
            return Math.max(maxLen, longestSubstring(s.substring(start), k));
        }
    }
}
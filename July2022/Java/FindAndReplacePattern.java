
// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<String>();
        int l = pattern.length();
        int [] pat = new int[l];
        for (int i = 0; i < l; i++) {
            pat[i] = (int)pattern.charAt(i)-97;
        }
        for (String word : words) {
            int [] map = new int[26];
            int [] hash = new int[26];
            Arrays.fill(map, -1);
            boolean flag = true;
            for (int i = 0; i < l; i++) {
                int val = (int)word.charAt(i)-97;
                
                if (map[pat[i]] == -1) {
                    if (hash[val] != 0) { flag = false; break; } // multi mapping not allowed
                    map[pat[i]] = val;  // assign value to this pattern character key
                    hash[val] = 1;
                }
                else {
                    if (map[pat[i]] != val) {   // pattern key-value mismatch
                        flag = false;
                        break;
                    }
                }
            }
            if (flag == true) res.add(word);
        }
        return res;
    }
}

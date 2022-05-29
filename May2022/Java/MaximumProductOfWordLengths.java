
// @saorav21994
// TC : O(n^2)
// SC : O(n)

class Solution {
    public int maxProduct(String[] words) {
        int l = words.length;
        int [] mask = new int[l];
        int [] wordlen = new int[l];
        for (int i = 0; i < l; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= (1 << c-'a');
            }
            wordlen[i] = words[i].length();
        }
        int res = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                if ((mask[i] & mask[j]) == 0)
                    res = Math.max(res, wordlen[i] * wordlen[j]);
            }
        }
        return res;
    }
}

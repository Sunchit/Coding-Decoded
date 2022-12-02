// @saorav21994

class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        /*  
            TRUE condition ::
            1. Both words should contain the exact same different characters.
            2. The count of frequency of diff. character in both words should be same.
        */

        int l1 = word1.length();
        int l2 = word2.length();
        
        if (l1 != l2) return false;
        
        int [] f1 = new int[26];
        int [] f2 = new int[26];
        
        for (int i = 0; i < l1; i++) {
            f1[(int)word1.charAt(i)-97] += 1;
            f2[(int)word2.charAt(i)-97] += 1;
        }
        
        for (int i = 0; i < 26; i++) {
            if ((f1[i] > 0 && f2[i] == 0) || (f2[i] > 0 && f1[i] == 0)) return false;
        }
        
        Arrays.sort(f1);
        Arrays.sort(f2);
        
        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) return false;
        }
        return true;

    }
}

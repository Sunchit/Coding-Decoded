
// @saorav21994
// TC : O(n)
// SC : O(26) ~ O(1)

class Solution {
    public boolean isAnagram(String s, String t) {
        int hash[] = new int[26];
        int sl = s.length();
        int tl = t.length();
        for (int i = 0; i < sl; i++) {
            hash[(int)s.charAt(i) - 97] += 1;
        }
        for (int i = 0; i < tl; i++) {
            hash[(int)t.charAt(i) - 97] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) return false;
        }
        return true;
    }
}

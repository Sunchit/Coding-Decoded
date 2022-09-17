
// @saorav21994
// TC : O(n)
// SC : O(256) = O(1)

class Solution {
    public int firstUniqChar(String s) {
        int hash[] = new int[26];
        int l = s.length();
        for (int i = 0; i < l; i++) {
            int al = (int)s.charAt(i) - 97;
            hash[al] += 1;
        }
        // for (int idx : hash) System.out.print(idx + " ");
        int res = -1;
        for (int i = 0; i < l; i++) {
            if (hash[(int)s.charAt(i) - 97] == 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}

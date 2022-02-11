
// @saorav21994
// TC : O(l1+l1+(l2-l1)) = O(l1+ l2)
// SC : O(26+26) = O(52) = Constant

/*
  Sliding window technique is used. 
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int [] hash1 = new int[26];
        int [] hash2 = new int[26];
        for (char ch : s1.toCharArray()) {
            hash1[(int)ch-97] += 1;
        }
        
        int sublen = s1.length();
        int matlen = 0;
        for (int i = 0; i < sublen; i++) {
            hash2[(int)s2.charAt(i)-97] += 1;
            if (hash1[(int)s2.charAt(i)-97] >= hash2[(int)s2.charAt(i)-97]) matlen += 1;
        }
        
        if (matlen == sublen) return true;
        int biglen = s2.length();
        for (int i = sublen ; i < biglen; i++) {
            if (hash1[(int)s2.charAt(i-sublen)-97] >= hash2[(int)s2.charAt(i-sublen)-97]) {
                matlen -= 1;
            }
            hash2[(int)s2.charAt(i-sublen)-97] -= 1;
            hash2[(int)s2.charAt(i)-97] += 1;
            if (hash1[(int)s2.charAt(i)-97] >= hash2[(int)s2.charAt(i)-97]) {
                matlen += 1;
            }
            if (matlen == sublen) return true;
        }
        return false;
    }
}

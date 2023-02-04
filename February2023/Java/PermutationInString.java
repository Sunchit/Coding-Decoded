// @saorav21994


// sliding window hash

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int sublen = s1.length();
        int biglen = s2.length();
        if (sublen > biglen)
            return false;
        
        int [] hash1 = new int[26];
        int [] hash2 = new int[26];
        
        for (int i = 0; i < sublen; i++) {
            hash1[(int)s1.charAt(i)-97] += 1;
        }
        
        int matlen = 0;
        
        for (int i = 0; i < sublen; i++) {
            hash2[(int)s2.charAt(i)-97] += 1;
            if (hash1[(int)s2.charAt(i)-97] >= hash2[(int)s2.charAt(i)-97]) {
                matlen += 1;
            }
        }
        
        if (matlen == sublen)
            return true;
        
        for (int i = sublen; i < biglen; i++) {
            
            // check if matlen needs to be decreased for out of window character
            if (hash1[(int)s2.charAt(i-sublen)-97] >= hash2[(int)s2.charAt(i-sublen)-97]) {
                matlen -= 1;
            }
            hash2[(int)s2.charAt(i-sublen)-97] -= 1;
            hash2[(int)s2.charAt(i)-97] += 1;
            
            // check for current matlen increase for current window character
            if (hash1[(int)s2.charAt(i)-97] >= hash2[(int)s2.charAt(i)-97]) {
                matlen += 1;
            }
            
            if (matlen == sublen) {
                return true;
            }
            
        }
        
        return false;
        
    }
}

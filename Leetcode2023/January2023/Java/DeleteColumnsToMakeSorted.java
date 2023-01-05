// @saorav21994

class Solution {
    public int minDeletionSize(String[] strs) {
        
        int l = strs.length;
        int w = strs[0].length();
        int [] hash = new int[w];   // initially zero
        
        for (int i = 0; i < l; i++) {
            int j = 0;
            for (char ch : strs[i].toCharArray()) {
                if (hash[j] == -1) {
                    j += 1;
                    continue;
                }
                else {
                    if (hash[j] > (int)ch) {
                        hash[j] = -1;
                    }
                    else {
                        hash[j] = Math.max(hash[j], (int)ch);
                    }
                }
                j += 1;
            }
            
        }
        
        int count = 0;
        for (int i = 0; i < w; i++) {
            if (hash[i] == -1) {
                count += 1;                
            }
        }
        
        return count;
        
    }
}

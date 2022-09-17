
// @saorav21994 
// TC : O(s.length()*k)   
// SC : O(min(s.length(), 2^k))

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int required = 1 << k;      // 2^k combinations required for k ( 0 -> 2^k-1)
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length()-k+1; i++) {
            String substr = s.substring(i, i+k);
            // System.out.println(substr);
            if (!set.contains(substr)) {
                set.add(substr);
                required -= 1;
            }
            if (required == 0)
                return true;            // all combinations found
        }
        return false;
    }
}

// For more optimized approach of rolling hash, refer to official solution

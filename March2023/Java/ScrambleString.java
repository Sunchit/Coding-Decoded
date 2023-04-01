class Solution {
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> dp = new HashMap<>();
        return helper(s1, s2, dp);
    }
    
    private boolean helper(String s1, String s2, Map<String, Boolean> dp) {
        // base case
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() <= 1 || s2.length() <= 1) {
            return false;
        }
        
        String key = s1 + "-" + s2;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        
        int n = s1.length();
        boolean flag = false;
        
        for (int i = 1; i <= n - 1; i++) {
            boolean swap = helper(s1.substring(0, i), s2.substring(n - i), dp) && helper(s1.substring(i), s2.substring(0, n - i), dp);
            if (swap) {
                flag = true;
                break;
            }
            
            boolean notSwap = helper(s1.substring(0, i), s2.substring(0, i), dp) && helper(s1.substring(i), s2.substring(i), dp);
            if (notSwap) {
                flag = true;
                break;
            }
        }
        
        dp.put(key, flag);
        return flag;
    }
}

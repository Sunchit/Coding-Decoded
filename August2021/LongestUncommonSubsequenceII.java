class Solution {
    public int findLUSlength(String[] strs) {
        int maxLen = -1;
        for(int i = 0; i < strs.length ; i++){
            boolean flag = false ;
            int currLen = strs[i].length() ;
            for(int j = 0 ; j<strs.length; j++)
            {

                if(i != j && isSubsequence(strs[i], strs[j]))
                {
                    flag = true ;
                    break ;
                }
            }
            if(!flag)
            {
                maxLen = Math.max(maxLen , currLen);
            }
        }
        return maxLen ;
    }

    public boolean isSubsequence(String a, String b) {
        if (a.equals(b)) return true;
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == a.length();
    }
}
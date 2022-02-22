
// @saorav21994
// TC = O(numberOfDigits)
// SC = O(1)  


class Solution {
    public int titleToNumber(String columnTitle) {
        char [] ch = columnTitle.toCharArray();
        int l = ch.length;
        int itr = 0, res = 0;
        for (int i = l-1; i >= 0; i--) {
            res += (int)Math.pow(26,itr)*(ch[i]-'A'+1);
            itr += 1;
        }
        return res;
    }
}

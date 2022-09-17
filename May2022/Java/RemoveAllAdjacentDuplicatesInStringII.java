
// @saorav21994
// TC : O(n)
// SC : O(n)
// Stack based approach


class Solution {
    public String removeDuplicates(String s, int k) {
        int l = s.length();
        char [] ch = s.toCharArray();
        int i, j;
        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        for (i = 1, j = 1; j < l; i++, j++) {
            ch[i] = ch[j];
            if (i == 0 || ch[i] != ch[i-1]) {
                st.push(i);
            }
            else if ((i-st.peek()+1) == k) 
                i = st.pop()-1;
        }
        return String.valueOf(ch, 0, i);
    }
}

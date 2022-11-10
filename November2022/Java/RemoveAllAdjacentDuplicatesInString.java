// @saorav21994

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            if (st.isEmpty() == false && st.peek() == ch) {
                st.pop();
            }
            else st.push(ch);
        }
        StringBuffer sb = new StringBuffer("");
        while (st.isEmpty() == false) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}

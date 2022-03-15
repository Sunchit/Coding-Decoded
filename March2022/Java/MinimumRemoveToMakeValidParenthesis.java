
// @saorav21994
// TC : O(n)
// SC : O(n)



class Solution {
    
    private class Pair {
        int index;
        char bracket;
        
        public Pair(int index, char bracket) {
            this.index = index;
            this.bracket = bracket;
        }
        
    }
    
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                st.push(new Pair(i, sb.charAt(i)));
            }
            else if (sb.charAt(i) == ')') {
                if (st.isEmpty()) 
                    st.push(new Pair(i, sb.charAt(i)));
                else {
                    Pair top = st.peek();
                    if (top.bracket == '(')
                        st.pop();
                    else {
                        st.push(new Pair(i, sb.charAt(i)));
                    }
                }
            }
        }
        
        while (!st.isEmpty()) {
            Pair top = st.pop();
            sb = sb.deleteCharAt(top.index);
        }
        
        return sb.toString();
    }
}


class Solution {
    // TC O(len(s))
    // SC O(len(s))
    public boolean isValid(String s) {
        Stack<Character> st =new Stack<Character>();
        for(char c: s.toCharArray()){
            if(st.empty()){
                st.push(c);
            } else{
                char topChar = st.peek();
                if(topChar == '(' && c ==')'){
                    st.pop();
                } else  if(topChar == '{' && c =='}'){
                    st.pop();
                } else  if(topChar == '[' && c ==']'){
                    st.pop();
                } else{
                    st.push(c);
                }
            }
        }
        return st.empty();
    }
}
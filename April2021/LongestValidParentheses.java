class Solution {
    // TC : O(n)
    // SC : O(n)
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<2){
            return 0;
        }

        Stack<Integer> st =new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push(i);
            } else{

                // current closing bracking

                if(!st.empty() && s.charAt(st.peek()) == '('){
                    st.pop();
                } else{
                    st.push(i);
                }
            }
        }

        int maxLen = 0;
        int endTerminal = s.length();

        while(!st.empty()){
            int startTerminal  = st.pop();
            maxLen = Math.max(maxLen, endTerminal - startTerminal -1);
            endTerminal = startTerminal;
        }

        return Math.max(endTerminal, maxLen);
    }
}
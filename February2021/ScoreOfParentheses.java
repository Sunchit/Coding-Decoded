class Solution {
    // TC : O(n)
    // SC : O(n) => ()()()() => n/2
    public int scoreOfParentheses(String s) {
        Stack<String> st = new Stack<>();

        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            if(st.empty()){
                st.push(c + "");
            } else {
                if(c == ')'){
                    int innerScore = 0;
                    while(!st.empty() && !st.peek().equals("(")){
                        innerScore += Integer.valueOf(st.peek());
                        st.pop();
                    }
                    st.pop();

                    if(innerScore == 0){ //()
                        st.push("1");
                    } else{
                        st.push(2*innerScore + "");
                    }
                } else{
                    st.push(c + "");
                }
            }
        }

        int score = 0;
        while(!st.empty()){ // ()()() // 1 1 1
            score += Integer.valueOf(st.peek());
            st.pop();
        }
        return score;
    }
}
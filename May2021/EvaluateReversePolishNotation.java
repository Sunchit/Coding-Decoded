class Solution {
    // TC  : O(n)

    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for(String el: tokens){
            if(isOperator(el)){

                int el2 = Integer.parseInt(st.pop());
                int el1 = Integer.parseInt(st.pop());
                int ans = 0;

                if(el.equals("*")){
                    ans = el1 *el2;
                } else if(el.equals("/")){
                    ans = el1/el2;
                }else if(el.equals("+")){
                    ans = el1 +el2;
                }else if(el.equals("-")){
                    ans = el1 -el2;
                }
                st.push(ans+"");
            } else {
                // operand
                st.push(el);
            }
        }

        return Integer.parseInt(st.peek());
    }

    private boolean isOperator(String el){
        if(el.equals("*") || el.equals("+") || el.equals("-") || el.equals("/")){
            return true;
        } else {
            return false;
        }
    }
}
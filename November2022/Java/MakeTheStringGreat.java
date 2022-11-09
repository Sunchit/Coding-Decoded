// @saorav21994

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        int l = s.length();
        for (int i = l-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }
            else {
                char ch = stack.peek();
                char cur = s.charAt(i);
                if ((int)ch == (int)cur-32 || (int)ch == (int)cur+32) {
                    stack.pop();
                }
                else {
                    stack.push(cur);
                }
            }
        }    
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()+"");
        }
        return sb.toString();
    }
}


// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int scoreOfParentheses(String s) {
        int l = s.length();
        int count = 0;
        int res = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == '(')
                count += 1;
            else {
                count -= 1;
                if (s.charAt(i-1) == '(')
                    res += (int)Math.pow(2, count);
            }
        }
        return res;
    }
}

// Author : @romitdutta10
// TC : O(n)
// SC : O(n)
// Problem : https://leetcode.com/problems/score-of-parentheses/

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == ')') {
                int innerCount = 0;
                
                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    innerCount += Integer.parseInt(stack.pop());
                }
                stack.pop();
                stack.push(String.valueOf(Math.max(2 * innerCount, 1)));
                
            } else {
                stack.push(String.valueOf(c));
            }
        }
        
        int res = 0;
        
        while(!stack.isEmpty()) {
            res += Integer.parseInt(stack.pop());
        }
        
        
        return res;
    }
}

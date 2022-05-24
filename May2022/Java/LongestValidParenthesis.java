
// @saorav21994
// TC : O(2*n) = O(n)
// SC : O(n)

// This is my version of stack. For more optimized version of stack (absolute O(n), mine's 2*n) can check official solution. 
// This is what I came up with during an interview.

// Treat ( as -1 and ) as -2. The idea is whenever we encounter a ) above ( we count +2 and keep in stack. Each time we add up all the values and keep max of them.

class Solution {
    public int longestValidParentheses(String s) {
        char [] schar = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        // -1 -> ( ; -2 -> )
        
        int max = 0;
        int tmp = 0;
        for (char ch : schar) {
            if (ch == '(') {
                stack.push(-1);
            }
            else {          // ch == ')'
                if (stack.isEmpty() || stack.peek() == -2)
                    stack.push(-2);     // we can also do continue as it does not matter. ) can NEVER be resolved at a later stage.
                else {
                    tmp = 0;
                    // take out all the points we have collected so far -> Ex. ( 2 4 2 [)]<-current character => (8 [)]<-current character => 10
                    while (!stack.isEmpty() && stack.peek() != -1 && stack.peek() != -2) {
                        tmp += stack.pop();
                    }
                    max = Math.max(tmp, max);
                    // If the top is ( then only we will add 2 to 8 in example above else we won't.
                    if (!stack.isEmpty() && stack.peek() == -1) {
                        stack.pop();
                        tmp += 2;
                        stack.push(tmp);
                        max = Math.max(tmp, max);
                    }
                    else {
                        stack.push(-2);
                    }
                    tmp = 0;
                    
                    // The below step is for finishing off because the stack may be something like < ) 2 4 2 6 > => should become < ) 14 >
                    while (!stack.isEmpty() && stack.peek() != -1 && stack.peek() != -2) {
                        tmp += stack.pop();
                    }
                    max = Math.max(tmp, max);
                    if (tmp != 0)
                        stack.push(tmp);
                }
            }
        }
        return max;
    }
}

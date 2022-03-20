
// @saorav21994
// TC : O(n)
// SC : O(n)

// For each item see if it can be popped, if so pop it and continue. At end see if all elements from both push and pop array have been processed.

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushLen = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int item: pushed) {
            stack.push(item);
            while (!stack.isEmpty() && i < pushLen && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        if (i == pushLen)
            return true;
        return false;
    }
}

// Author: @romitdutta10
// TC : O(n)
// SC : O(n)
// Problem : https://leetcode.com/problems/validate-stack-sequences/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        
        int index = 0;
        int n = popped.length;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++) {
            stack.push(pushed[i]);
            
                
                
            while(!stack.isEmpty() && index < n && popped[index] == stack.peek() ) {
                stack.pop();
                index++;
            }
            
        }
        
        return stack.isEmpty();
    }
}

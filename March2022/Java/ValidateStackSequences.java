
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

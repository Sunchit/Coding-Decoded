
// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String s : ops) {
            if (s.equals("+")) {
                int top = stack.pop();
                int newValue = top + stack.peek();
                stack.push(top);
                stack.push(newValue);
                res += newValue;
            }
            else if (s.equals("D")) {
                int newValue = stack.peek() * 2;
                stack.push(newValue);
                res += newValue;a
            }
            else if (s.equals("C")) {
                int newValue = stack.pop();
                res -= newValue;
            }
            else {
                int newValue = Integer.parseInt(s);
                stack.push(newValue);
                res += newValue;
            }
        }
        return res;
    }
}

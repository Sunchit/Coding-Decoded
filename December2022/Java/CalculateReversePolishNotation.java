// @saorav21994

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> container = new Stack<Integer>();
        for (String token : tokens) {
            if (token.charAt(0) == '+' && token.length() == 1) {
                int second = container.pop();
                int first = container.pop();
                int tmpRes = first + second;
                container.push(tmpRes);
            }
            else if (token.charAt(0) == '-' && token.length() == 1) {
                int second = container.pop();
                int first = container.pop();
                int tmpRes = first - second;
                container.push(tmpRes);
            }
            else if (token.charAt(0) == '*' && token.length() == 1) {
                int second = container.pop();
                int first = container.pop();
                int tmpRes = first * second;
                container.push(tmpRes);
            }
            else if (token.charAt(0) == '/' && token.length() == 1) {
                int second = container.pop();
                int first = container.pop();
                int tmpRes = (int)Math.floor(first / second);
                container.push(tmpRes);
            }
            else {      // it is a number
                container.push(Integer.parseInt(token));
            }
            // System.out.println("stack = " + container);
        }
        return container.peek();
    }
}

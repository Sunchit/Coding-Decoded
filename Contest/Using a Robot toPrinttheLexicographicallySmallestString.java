// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/
// @author: anuj0503
class Solution {
    public String robotWithString(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];

        dp[n] = (int)('z') + 10;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1], (int)str.charAt(i));
        }

        Stack<Character> stack = new Stack<Character>();
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < n; i++)
        {
            if (!stack.isEmpty() && dp[i] >= stack.peek()) {
                s.append(stack.peek());
                stack.pop();
                i--;
            } else if (dp[i] == str.charAt(i)) {
                s.append(str.charAt(i));
            } else {
                stack.push(str.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            s.append(stack.peek());
            stack.pop();
        }

        return s.toString();
    }
}

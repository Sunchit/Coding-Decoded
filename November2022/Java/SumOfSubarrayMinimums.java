// @saorav21994

class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);     // index can not be < 0

        int res = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i <= arr.length; i++) {

            int cur = (i < arr.length) ? arr[i] : 0;    // minimum value of arr is 1, so 0 will make sure to process all the last element

            while (stack.peek() != -1 && cur < arr[stack.peek()]) {
                int stIdx = stack.pop();
                int leftBound = stIdx-stack.peek();
                int rightBound = i - stIdx;
                long value = (leftBound*rightBound*(long)arr[stIdx])%MOD;
                res += value;
                res %= MOD;
            }

            stack.push(i);

        }

        return res;
    }
}

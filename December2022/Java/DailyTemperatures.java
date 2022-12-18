// @saorav21994

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int l = temperatures.length;
        int [] res = new int[l];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < l; i++) {
            if (st.isEmpty()) {
                st.push(i);
            }
            else {
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    int top = st.pop();
                    res[top] = i-top;
                }
                st.push(i);
            }
        }

        return res;

    }
}

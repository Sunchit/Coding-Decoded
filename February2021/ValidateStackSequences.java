class Solution {

    // TC : O(n)
    // SC : O(n)
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st= new Stack<>();
        int s = 0;
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);
            while(!st.empty() && popped[s] ==st.peek()){
                st.pop();
                s++;
            }
        }
        return st.empty();
    }
}
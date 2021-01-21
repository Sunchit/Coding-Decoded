class Solution {

    // TC : O(n)
    // SC : O(n)
    public int[] mostCompetitive(int[] nums, int k) {
        int noOfDElToBeRemoved = nums.length -k;
        Stack<Integer> st = new Stack<>();
        for(int el: nums){

            while(!st.empty() && noOfDElToBeRemoved>0 && st.peek()> el){
                st.pop();
                noOfDElToBeRemoved--;
            }

            st.push(el);
        }

        while(st.size()>k){
            st.pop();
        }

        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}
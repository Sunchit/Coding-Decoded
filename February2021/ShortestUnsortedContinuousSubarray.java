class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int minIndex = nums.length;
        for(int i = 0;i<nums.length;){
            if(st.empty()){
                st.push(i);
                i++;
            } else {
                if(!st.empty() && nums[st.peek()] > nums[i]){
                   minIndex = Math.min(st.peek(), minIndex);
                    st.pop();
                } else{
                    st.push(i);
                    i++;
                }
            }
        }

        st.clear();

        int right = 0;
        for(int i=nums.length-1;i>=0;){
            if(st.empty()){
                st.push(i);
                i--;
            } else{
                if(!st.empty() && nums[st.peek()]< nums[i]){
                    right = Math.max(st.peek(), right);
                    st.pop();
                } else{
                    st.push(i);
                    i--;
                }
            }
        }

       // System.out.println(minIndex + " "+ right);
        if(right< minIndex){
            return 0;
        }
        return right - minIndex +1;
    }
}
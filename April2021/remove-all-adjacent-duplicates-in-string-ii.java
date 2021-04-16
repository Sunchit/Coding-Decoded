class Solution {

    // Tc: O(n)
    // Sc:  O(n)
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(st.isEmpty() || st.peek().getKey() !=c){
                st.push(new Pair<>(c, 1));
            } else{
                // matching case
                Pair<Character, Integer> head = st.pop();
                st.push(new Pair<>(head.getKey(), head.getValue()+1));

                if(st.peek().getValue() == k){
                    st.pop();
                }
            }
        }

        String ans =  "";
        while(!st.isEmpty()){
            Pair<Character, Integer> head = st.pop();
            int freq = head.getValue();
            while(freq-->0){
                ans = head.getKey() +ans;
            }
        }

        return ans;
    }
}
class Solution {

    // TC : O(n)
    // SC :O(n) => "))(("
    public String minRemoveToMakeValid(String s) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ')' || c == '('){
                if(st.empty()){
                    st.push(new Pair<>(c, i));
                } else{
                    if(c == ')' && st.peek().getKey() == '('){
                        st.pop();
                    } else{
                        st.push(new Pair<>(c, i));
                    }
                }
            }
        }

        Set<Integer> indexesToBeRemoved = new HashSet<>();
        while(!st.empty()){
            indexesToBeRemoved.add(st.peek().getValue());
            st.pop();
        }

        String ans = "";
        for(int i=0;i<s.length();i++){
            if(!indexesToBeRemoved.contains(i)){
                ans += s.charAt(i);
            }
        }

        return ans;
    }
}
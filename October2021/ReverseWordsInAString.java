class Solution {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        Stack<String> st = new Stack<>();
        String word = "";
        for(int i=0;i<s.length(); i++){

            // Leading spaces
            while(i<s.length() && charArray[i] == ' '){
                i++;
            }

            while(i<s.length() && charArray[i] != ' '){
                //  System.out.println(charArray[i]);
                word += charArray[i];
                i++;
            }
            st.push(word);
            word = "";
        }

        String ans = "";
        while(!st.empty()){
            String top = st.pop();
            ans = ans + " " + top;
        }

        return ans.trim();

    }
}
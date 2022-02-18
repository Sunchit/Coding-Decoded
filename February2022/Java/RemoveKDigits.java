

// @saorav21994
// Stack implementation 
// TC : O(n)
// SC : O(n)


class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        for (char ch : num.toCharArray()) {
            while (!st.isEmpty() && st.peek() > ch && k > 0) {
                st.pop();
                k -= 1;
            }   
            st.push(ch);
        }
        
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k -= 1;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb = sb.reverse();
        
        // remove leading zeros
        int i = 0;
        for (char ch : sb.toString().toCharArray()) {
            if (ch != '0')
                break;
            i += 1;
        }
        
        String res = sb.toString().substring(i, sb.length());
        if (res == "" ||  res == null)
            return "0";
        return res;
        
        
    }
}

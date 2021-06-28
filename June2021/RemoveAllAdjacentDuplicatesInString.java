// TC : O(n)
// SC : O(n)
class Solution {
     public String removeDuplicates(String s) {
         Stack<Character> st = new Stack<>();
         for(char c : s.toCharArray()){
             if(!st.empty() && st.peek() == c){
              st.pop();
             } else {
                 st.push(c);
             }

         }
         String ans = "";
         while(!st.empty()){
             ans = st.pop() + ans;
         }
         return ans;
     }

  public String removeDuplicates(String s) {
    StringBuilder sb = new StringBuilder();
    for(char c : s.toCharArray()){
      if(sb.length()>0 && sb.charAt(sb.length()-1) == c){
        sb.deleteCharAt(sb.length()-1);
      } else{
        sb.append(c);
      }

    }
    return sb.toString();
  }
}

// @saorav21994

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String [] tokens = s.split("\\s+");
        for (String token : tokens) {
            sb.append(new StringBuilder(token).reverse());
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length()-1);
    }
}

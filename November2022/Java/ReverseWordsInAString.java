// @saorav21994

class Solution {
    public String reverseWords(String s) {
        String [] splitted = s.split("\\s+");
        // System.out.println("print");
        // for (String sp : splitted) {
        //     System.out.println(sp);
        // }
        int l = splitted.length;
        StringBuilder sb = new StringBuilder("");
        for (int i = l-1; i >= 0; i--) {
            sb.append(splitted[i]);
            if (i != 0)
                sb.append(" ");
        }
        return sb.toString().trim();
    }
}

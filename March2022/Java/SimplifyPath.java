
// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public String simplifyPath(String path) {
        path = path.replaceAll("//+", "/");
        // System.out.println(path);
        String [] levels = path.split("/");
        Deque<String> st = new ArrayDeque<>();
        // System.out.println("print string array");
        // for (String s : levels) {
        //     System.out.println(s + "-");
        // } 
        for (String s : levels) {
            // System.out.println(s);
            if (!s.equals("..") && !s.equals(".")) {
                st.offer(s);
            }
            else if (s.equals("..") && !st.isEmpty()) {
                st.removeLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            // System.out.println(st.peek());
            sb.append(st.poll());
            sb.append("/");
            // System.out.println(sb);
        }
        if (sb.length() == 0 || sb.charAt(0) != '/')
            sb.insert(0, "/");
        String res = sb.toString();
        if (res.length() == 1)
            return res;
        else
            return res.substring(0, res.length()-1);
    }
}

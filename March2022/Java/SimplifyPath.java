
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

// Author: @romitdutta10
// TC : O(N)
// SC: O(N)
// Problem : https://leetcode.com/problems/simplify-path/
// Solution without using stack

class Solution {
    public String simplifyPath(String path) {
        String paths[] = path.split("/");
        
        StringBuilder res = new StringBuilder();
        
        for(String p : paths) {
            if(p.length() <= 0 || p.equals(".")) {
                continue;
            }
            if(p.equals("..")) {
                if(res.length() > 0) {
                    res.setLength(res.lastIndexOf("/"));
                }
            }  else {
                res.append("/").append(p);
            }
            
        }
        
        
        return res.length() == 0 ? "/" : res.toString();
    }
}

// Author: @romitdutta10
// TC : O(N)
// SC: O(N)
// Problem : https://leetcode.com/problems/simplify-path/
// Solution with using stack

class Solution {

    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] pathList = path.split("\\/");

        for(String p : pathList){
            if(p.length() == 0 || p.equals(".")){
                continue;
            } else if(p.equals("..")){
                if(!st.empty()){
                    st.pop();
                }
            } else {
                st.push(p);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.empty()){
            ans.insert(0, st.pop() + "/");
        }

        if(ans.length() == 0){
            return "/";
        }else{
            return "/" + ans.substring(0, ans.length() -1);
        }

    }
}

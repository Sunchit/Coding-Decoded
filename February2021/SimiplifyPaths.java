class Solution {


    // TC : O(n)
    // SC : O(n)
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
                // string case
                st.push(p);
            }
        }
        // StringBuilder
        String ans = "";
        while(!st.empty()){
            ans =st.pop() +"/"+ ans;
        }

        if(ans.length() == 0){
            return "/";
        }else{
            return "/" + ans.substring(0, ans.length() -1);
        }

    }
}
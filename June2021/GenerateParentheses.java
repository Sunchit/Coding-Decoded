class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        // mutable
        backtrackHelper(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void backtrackHelper(List<String> list, StringBuilder str, int open, int closed, int n){
        // aborting condition
        if(closed>open){
            return ;
        }

        if(closed == open && str.length() == n*2 ) {
            list.add(str.toString());
            return;
        }

        if(open < n) {
            str.append("(");
            backtrackHelper(list, str, open+1, closed, n);
            str.deleteCharAt(str.length()-1);;
        }
        if(closed < open) {
            str.append(")");
            backtrackHelper(list, str, open, closed+1, n);
            str.deleteCharAt(str.length()-1);;
        }
    }
}
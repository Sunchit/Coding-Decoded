class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        if(S.length() == 0){
            return ans;
        }
        helper(S.toCharArray(), ans, 0);
        return ans;
    }

    private void helper(char[] str, List<String> ans, int index){
        if(index == str.length){
            ans.add(new String(str));
            return ;
        }

        if(Character.isDigit(str[index])){
            helper(str, ans, index+1);
            return ;
        } else{
            str[index] = Character.toLowerCase(str[index]);
            helper(str, ans, index+1);


            str[index] = Character.toUpperCase(str[index]);
            helper(str, ans, index+1);
        }
    }
}
// Author: Mahesh Reddy B N
// Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/


class Solution {
    public List<String> letterCombinations(String digits) {
        String []str = new String[10];
        str[2] = "abc";
        str[3] = "def";
        str[4] = "ghi";
        str[5] = "jkl";
        str[6] = "mno";
        str[7] = "pqrs";
        str[8] = "tuv";
        str[9] = "wxyz";
        List<String> al = new ArrayList<>();
        helper(al,digits,str,0,"");
        return al;
    }
    public void helper(List<String> al,String s,String[] str,int si,String cur){
        if(si>= s.length()){
            if(cur.length()>0){
              al.add(cur);
            }
            return;
        }
        int curr = s.charAt(si) - '0';
        for(int i=0;i<str[curr].length();i++){
            String past = cur;
            cur+= str[curr].charAt(i);
            helper(al,s,str,si+1,cur);
            cur = past;
        }
    }
}
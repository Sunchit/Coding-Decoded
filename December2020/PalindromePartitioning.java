class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res  = new ArrayList<>();
        if(s == null || s.length()==0){
            return res;
        }

        helper(res, new ArrayList<>(), s);
        return res;
    }

    private void helper(List<List<String>> res, List<String> currList, String inputStr){
        if(inputStr.length() == 0){
            res.add(new ArrayList<>(currList));
            return ;
        }
        for(int i=0;i<inputStr.length();i++){
            String firstPart = inputStr.substring(0, i+1);
            if(isPalindrome(firstPart)){
                currList.add(firstPart);
                String secondPart = inputStr.substring(i+1, inputStr.length());
                helper(res, currList, secondPart);
                currList.remove(currList.size() -1);

            }
        }
    }

    private boolean isPalindrome(String s){
        String reversedStr = new StringBuilder(s).reverse().toString();
        return s.equals(reversedStr);
    }
}
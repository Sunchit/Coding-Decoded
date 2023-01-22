class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfsHelper(res, new ArrayList<String>(), s);
        return res;
    }
    
    private void dfsHelper(List<List<String>> res, List<String> currList, String s) {
       
        if(s.length() == 0) {
            res.add(new ArrayList<String>(currList));            
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            
            if(checkPalindrome(s, 0, i)) {
                // found one portion as palindrome
                currList.add(s.substring(0, i+1));
                // apply DFS on remaining portion
                dfsHelper(res, currList, s.substring(i+1));
                // undo 
                currList.remove(currList.size()-1);
            }
        }
    }

    private boolean checkPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}

// [aab] 

// [a ,(ab)]                           [aa, (b)]

// [a, [a,(b)]]    [a, [ab]]            [aa, [b]]

// [a, a, b]     


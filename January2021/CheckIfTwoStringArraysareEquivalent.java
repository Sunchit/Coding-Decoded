
class Solution {
    // TC : O(n) n stands for no of elements in wordList1 + wordList2
    // SC : O(m) , m stands for no of char in wordList1 + wordsList2
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return concatStringList(word1).equals(concatStringList(word2));
    }

    private String concatStringList(String[] wordList){
        String ans = "";
        for(String word: wordList){
            ans += word;
        }
        return ans;
    }
}
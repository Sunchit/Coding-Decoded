
// @saorav21994

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer s1 = new StringBuffer("");
        StringBuffer s2 = new StringBuffer("");
        for (String word : word1) {
            s1.append(word);
        }
        for (String word : word2) {
            s2.append(word);
        }
        if (s1.toString().equals(s2.toString())) return true;
        return false;
    }
}

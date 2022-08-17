
// @saorav21994
// TC : O(wordCount*avg_length_of_each_word)
// SC : O(wordCount)

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        int len = words.length;
        String [] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> res = new HashSet();
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int l = word.length();
            StringBuilder str = new StringBuilder("");
            for (int j = 0; j < l; j++) {
                str.append(morse[(int)word.charAt(j)-97]);
            }
            res.add(String.valueOf(str));
        }
        return res.size();
    }
}

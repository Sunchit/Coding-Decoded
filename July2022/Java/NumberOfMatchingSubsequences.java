
// @saorav21994
// TC : O(word.length * avg. length of word)
// SC : O(word.length * avg. length of word)

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        HashSet<String> isSub = new HashSet<>();
        HashSet<String> notSub = new HashSet<>();
        for (String word : words) {
            if (isSub.contains(word) == true) { res += 1; continue; }
            else if (notSub.contains(word) == true) { continue; }
            int prev = -1;
            int flag = 0;
            // System.out.println("word = " + word);
            for (Character c : word.toCharArray()) {
                int cur = s.indexOf(c, prev+1);
                // System.out.println("cur = " + cur);
                if (cur == - 1) { flag = 1; break; }
                prev = cur;
            }
            if (flag == 0) { res += 1; isSub.add(word); }
            else { notSub.add(word); }
            // System.out.println("flag = " + flag + " res = " + res);
        }
        return res;
    }
}

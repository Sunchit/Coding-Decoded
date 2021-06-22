// https://leetcode.com/problems/number-of-matching-subsequences/

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < S.length(); i++) {
            map.putIfAbsent(S.charAt(i), new LinkedList<>());
        }

        for(String word : words) {
            char startChar = word.charAt(0);
            if(map.containsKey(startChar)) {
                map.get(startChar).offer(word);
            }
        }
        for(int i = 0; i < S.length(); i++) {
            char startChar = S.charAt(i);
            Queue<String> q = map.get(startChar);
            int size = q.size();
            for(int k = 0; k < size; k++) {
                String str = q.poll();
                if(str.substring(1).length() == 0) {
                    ans++;
                } else {
                    if(map.containsKey(str.charAt(1))) {
                        map.get(str.charAt(1)).add(str.substring(1));
                    }
                }
            }
        }
        return ans;
    }
}
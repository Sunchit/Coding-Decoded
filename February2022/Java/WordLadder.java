
// @saorav21994
// TC : O(beginWord.length() * beginWord.length() * wordList.size())
// SC : O(n)

// Hard - Map + BFS Queue (explained by CodingDecoded July last year)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        queue.offer(beginWord);
        map.put(beginWord, 1);
        while (queue.isEmpty() != true) {
            String word = queue.poll();
            int trans = map.get(word);
            for (String wordi : wordList) {
                if (map.containsKey(wordi) == false && diffByChar(wordi, word) == 1) {
                    if (wordi.equals(endWord) == true) {
                        return trans+1;
                    }
                    map.put(wordi, trans+1);
                    queue.offer(wordi);
                }
            }
        }
        return 0;
    }
    
    private int diffByChar(String a, String b) {
        int l = a.length();
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count += 1;
                if (count == 2) return count;
            }
        }
        return count;
    }
}

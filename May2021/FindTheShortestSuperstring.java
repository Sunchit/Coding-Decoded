class Solution {
    public String shortestSuperstring(String[] words) {
        Map<String, String> map = new HashMap<>();

        // mark every word as unused
        int unused = 0;  // integer is used as a bit array
        for(int i = 0; i < words.length; i++) {

            unused |= 1 << i;
        }

        return shortestSuperstring(words, "", unused, map);
    }

    private String shortestSuperstring(String[] words, String startWord, int unused, Map<String, String> map) {
        if (unused == 0) {
            return startWord;
        }

        // check 
        String key = startWord + "|" + unused;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        String shortest = null;
        for(int i = 0; i < words.length; i++) {
            if (!isConsumed(unused, i)) {
                // get the shortest superstring starting from an unused word
                String superstring = shortestSuperstring(words, words[i], consume(unused, i), map);

                // "append" the shortest superstring to the start word
                String appended = overlapAppend(startWord, superstring);

                // keep the shortest
                if (shortest == null || appended.length() < shortest.length()) {
                    shortest = appended;
                }
            }
        }
        map.put(key, shortest);
        return shortest;
    }


    // Concat string a to b . For example, "bake" and "kelt" => "bakelt"
    private String overlapAppend(String a, String b) {
        for(int i = Math.max(1, a.length() - b.length()); i < a.length(); i++) {
            boolean match = true;
            for(int j = i; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j - i)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return a.substring(0, i) + b;
            }
        }
        return a + b;
    }

    private boolean isConsumed(int unused, int i) {
        return ((unused >> i) & 1) == 0;
    }

    private int consume(int unused, int i) {
        return unused & ~(1 << i);
    }

}

// @saorav21994


class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int space = 0, spcIdx = -1;
        
        // words[] array will be unique
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
            if (words[i].equals("") == true) {
                space = 1;
                spcIdx = i;
            }
        }
        
        // store reverse of each word in a separate array to prevent reverse calculation twice for the first 2 cases.
        String [] wordsRev = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsRev[i] = new StringBuilder(words[i]).reverse().toString();
        }
        
        // "" case
        if (spcIdx != -1) {
            for (int i = 0; i < words.length; i++) {
                if (i == spcIdx) continue;
                if (wordsRev[i].equals(words[i]) == true) {
                    res.add(Arrays.asList(i, spcIdx));
                    res.add(Arrays.asList(spcIdx, i));
                }
            }
        }
        
        // equal length palindrome case
        for (int i = 0; i < words.length; i++) {
            Integer idx = map.get(wordsRev[i]);
            if (idx != null && idx != i) {
                res.add(Arrays.asList(i, idx));
            }
        }
        
        // partial palindrome case
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                String lrev = new StringBuilder(left).reverse().toString();
                String rrev = new StringBuilder(right).reverse().toString();
                
                // left palindrome check and check if right reverse part exists in map
                if (lrev.equals(left) && map.containsKey(rrev)) {
                    res.add(Arrays.asList(map.get(rrev), i));
                }
                // right palindrome check and check if left reverse part exists in map
                if (rrev.equals(right) && map.containsKey(lrev)) {
                    res.add(Arrays.asList(i, map.get(lrev)));
                }
            }
        }
        
        return res;
    }
}

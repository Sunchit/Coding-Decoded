
// @saorav21994
// TC : O(no. of words * length(word)^2 + queries)
// SC : O(no. of words * length(word)^2)


class WordFilter {
    
    HashMap<String, Integer> map;
    
    public WordFilter(String[] words) {
        
        map = new HashMap<>();
        
        for (int lastIdx = words.length-1; lastIdx >= 0; lastIdx--) {
            
            String word = words[lastIdx];
            
            // find all possible suffix and prefix and put them in map -> prefix_suffix
            for (int i = 1; i <= word.length(); i++) {
                for (int j = 0; j < word.length(); j++) {
                    
                    String prefix = word.substring(0, i);
                    String suffix = word.substring(j);
                    
                    // only put if absent, as we are to return the greatest index (we are already traversing from back)
                    map.putIfAbsent(prefix+"_"+suffix, lastIdx);
                
                }
            }
        }
        
        
    }
    
    public int f(String prefix, String suffix) {
        
        Integer val = map.get(prefix+"_"+suffix);
        return (val == null) ? -1 : val;
        
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */

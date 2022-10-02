// https://leetcode.com/problems/remove-letter-to-equalize-frequency/
// @author: anuj0503
class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] == 0) continue;
            
            freq[i]--;
            
            if(isAllEqual(freq)){
                return true;
            }
            
            freq[i]++;
        }
        
        return false;
    }
    
    private boolean isAllEqual(int[] freq){
        Set<Integer> s = new HashSet<>();
        
        for(int f : freq){
            if(f == 0) continue;
            s.add(f);
        }
        
        return s.size() == 1;
    }
}

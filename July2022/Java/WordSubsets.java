
// @saorav21994
// TC : O(26*words1.length*10 + words2.length*10)
// SC : O(26) ~ O(1)

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        // Max Union of all the words of words2 will be the required for each word of words1
        
        int [] maxFreq = new int[26];
        List<String> res = new ArrayList<>();
        
        for (String word : words2) {
            int [] curFreq = new int[26];
            makeUnion(word, curFreq, maxFreq);
        }
        
        for (String word : words1) {
            int [] arr = maxFreq.clone();
            for (char ch : word.toCharArray()) {
                arr[ch-'a'] -= 1;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                res.add(word);
        }
        
        return res;
        
    }
    
    public void makeUnion(String word, int [] curFreq, int [] maxFreq) {
        for (char ch : word.toCharArray()) {
            curFreq[ch-'a'] += 1;
            maxFreq[ch-'a'] = Math.max(maxFreq[ch-'a'], curFreq[ch-'a']);
        }
    }
    
}

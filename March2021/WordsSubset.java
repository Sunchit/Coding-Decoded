class Solution {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans = new ArrayList<>();
        int[] maxFreqAcrossB = new int[26];
        for(String bStr : B){
            int[] freqCountBStr = freq(bStr);
            for(int i=0;i<26;i++){
                maxFreqAcrossB[i] = Math.max(maxFreqAcrossB[i], freqCountBStr[i]);
            }
        }

        for(String aStr: A){
            int[] freqCountAStr =freq(aStr);
            boolean foundAllChar = true;
            for(int i=0;i<26;i++){
                if(freqCountAStr[i] < maxFreqAcrossB[i]){
                    foundAllChar = false;
                    break;
                }
            }

            if(foundAllChar){
                ans.add(aStr);
            }
        }

        return ans;

    }

    // O(len(s))
    private int[] freq(String s){
        int[] freqCount = new int[26];
        for(char c: s.toCharArray()){
            freqCount[c-'a']++;
        }

        return freqCount;

    }
}
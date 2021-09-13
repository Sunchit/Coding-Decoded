class Solution {
    //TC : O(len(text))
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char c : text.toCharArray()){
            freq[c-'a']++;
        }

        char[] balloon = new char[]{'b','a','l','o','n'};
        int minFreq = Integer.MAX_VALUE;
        for(char c : balloon){
            if(c == 'l' || c=='o'){
                freq[c-'a'] = freq[c-'a']/2;
            }

            minFreq = Math.min(freq[c-'a'], minFreq);
        }
        return minFreq==Integer.MAX_VALUE? 0: minFreq;
    }
}
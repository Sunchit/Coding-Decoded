class Solution {
    // TC : O(nlogn)
     public boolean isAnagram(String s, String t) {
         char[] sChar = s.toCharArray();
         char[] tChar = t.toCharArray();

         Arrays.sort(sChar);
         Arrays.sort(tChar);
         return (new String(sChar)).equals(new String(tChar));
     }

    // TC : O(n)
    // SC : O(26)
    public boolean isAnagram(String s, String t) {
        int[] freqS = getFreqMap(s);
        int[] freqT = getFreqMap(t);

        for(int i=0;i<26;i++){
            if(freqS[i] != freqT[i]){
                return false;
            }
        }
        return true;
    }

    private int[] getFreqMap(String str){
        int[] freq = new int[26];
        for(char c: str.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}
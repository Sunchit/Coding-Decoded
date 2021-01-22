class Solution {

    // TC : O(max Len(word1, word2)) O(max(l1, l2))

    // SC: O(1)
    public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for(char c : word1.toCharArray()){
            freq1[c -'a']++;
            set1.add(c);
        }


        for(char c : word2.toCharArray()){
            freq2[c -'a']++;
            set2.add(c);
        }

        Set<Integer> freqSet1 = new HashSet<>();
        Set<Integer> freqSet2 = new HashSet<>();

        for(int freq : freq1){
            freqSet1.add(freq);
        }


        for(int freq : freq2){
            freqSet2.add(freq);
        }

        return set1.equals(set2) && freqSet1.equals(freqSet2);
    }
}
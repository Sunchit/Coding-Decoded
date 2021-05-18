class Solution {


    // TC : O(n * l*l) //
    // SC : O(n) // N No of words in input array
      public int longestStrChain(String[] words) {

        Arrays.sort(words, (a, b)->a.length() - b.length()); // TC : O(nlong)

        Map<String, Integer> dp = new HashMap<>();

        int ans = 0;

        for (String word : words) { // O(n)

            int longestChainWithCurrentWord = 0;

            for (int i = 0; i < word.length(); i++) { // O(l)
                // O(l)
                String predecessor = word.substring(0, i) + word.substring(i + 1, word.length());

                longestChainWithCurrentWord = Math.max(longestChainWithCurrentWord, dp.getOrDefault(predecessor, 0) + 1);

            }

            dp.put(word, longestChainWithCurrentWord);

            ans = Math.max(ans, longestChainWithCurrentWord);
        }
        return ans;
    }

}
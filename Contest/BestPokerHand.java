// https://leetcode.com/problems/best-poker-hand/
// @author: anuj0503
class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        Map<Character, Integer> suitMap = new HashMap<>();
        Map<Integer, Integer> rankMap = new HashMap<>();
        int maxFreq = 0;

        for(int i = 0; i < 5; i++){
            suitMap.put(suits[i], suitMap.getOrDefault(suits[i], 0) + 1);

            int newCount = rankMap.getOrDefault(ranks[i], 0) + 1;
            rankMap.put(ranks[i], newCount);

            maxFreq = Math.max(maxFreq, newCount);
        }

        if(suitMap.values().contains(5)) return "Flush";

        if(maxFreq >= 3) return "Three of a Kind";

        if(maxFreq == 2) return "Pair";

        return "High Card";
    }
}

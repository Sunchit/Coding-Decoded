// @saorav21994

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Max cost = 100000
        int [] hash = new int[100001];
        int max = 0;
        int l = costs.length;
        for (int cost : costs) {
            hash[cost] += 1;
            max = Math.max(max, cost);
        }
        
        int count = 0;
        for (int i = 0; i <= max; i++) {
            if (i > coins)
                break;
            if (hash[i] > 0) {
                int cur = Math.min(hash[i], coins/i);
                count += cur;
                coins -= (cur*i);
                
            }
        }
        
        return count;
    }
}

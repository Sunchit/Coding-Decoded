class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = m - 1;

            int ind = -1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                long product = (long) spells[i] * potions[mid];

                if (product >= success) {
                    ind = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            spells[i] = ind != -1 ? m - ind : 0;
        }

        return spells;        
    }
}

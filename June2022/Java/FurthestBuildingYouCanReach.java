

class Solution {

    // TC : O(nlogn)
    // SC : O(ladders)
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int gap = heights[i + 1] - heights[i];
            if (gap > 0) {
                pq.add(gap);
            }

            // The ladders are not enough you will have use bricks
            // which gap will u fill, where the value is least
            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }

            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }
}
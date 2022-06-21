

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



// @saorav21994

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap
        int i = 0;
        for (; i < heights.length-1; i++) {
            int d = heights[i+1]-heights[i];
            if (d <= 0) continue;       // next building is smaller
            else if (bricks >= d) {
                bricks -= d;
                pq.add(d);
            }
            else if (ladders > 0) {
                if (pq.isEmpty() == false) {
                    int max = pq.peek();
                    if (max > d) {
                        pq.poll();  // remove top(max) element
                        bricks += max;
                        pq.add(d);
                        bricks -= d;
                    }
                    ladders -= 1;
                }
            }
            else
                break;
        }
        return i;
    }
}


// @saorav21994
// Let number of stations = n
// TC : O(nlogn)
// Sc : O(n)

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int curfuel = startFuel;
        int stop = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int [] row: stations) {
            int next = row[0];
            int fuel = row[1];
            while(curfuel < next) {
                if (pq.isEmpty()) 
                    return -1;
                curfuel += pq.poll();
                stop += 1;
            }
            pq.offer(fuel);
        }
        while (curfuel < target) {
            if (pq.isEmpty()) 
                return -1;
            curfuel += pq.poll();
            stop += 1;
        }
        return stop;
    }
}

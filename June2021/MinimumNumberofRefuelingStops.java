class Solution {

    // TC : O(nlogn)
    // SC : O(n)
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int xCurrent = startFuel;
        int noOfStopsNeeded = 0;

        // Max Heap on the basis of fuel value
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->(b-a));

        for(int[] station: stations){
            int nextStationX = station[0];
            int fuelAtStation = station[1];

            while(xCurrent < nextStationX){// exhauted all your fuel
                if(pq.isEmpty()){
                    return -1;
                }
                int maxFuel = pq.poll();
                xCurrent= xCurrent+ maxFuel;
                noOfStopsNeeded++;
            }
            pq.offer(fuelAtStation);
        }

        // not yet reached the destination
        while(xCurrent< target){
            if(pq.isEmpty()){
                return -1;
            }
            // still have unvisited gas stations
            int maxFuel = pq.poll();
            xCurrent= xCurrent+ maxFuel;
            noOfStopsNeeded++;
        }
        return noOfStopsNeeded;
    }
}
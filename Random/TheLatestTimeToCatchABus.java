// https://leetcode.com/problems/the-latest-time-to-catch-a-bus/
// @author: anuj0503
class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        // Sort buses and passengers
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        Set<Integer> set = new HashSet(); // set to collect all passengers we are encounter
        int j = 0; // using j indexd to iterate over passengers
        int count = 0; // temporary variable to store available seats while iterating over passengers
        
        for(int bus : buses){ // for each bus
            count = capacity; // refill the avaialble seat to capacity
            
            // Running over passengers array, untill all seats are full or bus departure time is not meet
            while(j < passengers.length && count > 0 && bus >= passengers[j]){
                set.add(passengers[j]);
                count--; j++; // decreasing seat and jumping to next passengers
            }
        }
        
        int result = 1;
        
        // hopping onto one less passenger as above above while loop increment j by 1.
        if(j > 0)
            result = passengers[j-1];
        
        // If available seats is left, then last bus have space
        if(count > 0){
            result = buses[buses.length - 1];
        }
        
        // while we have some passenger with arrival time, we will decrease our arrival time by 1.
        while(set.contains(result)){
            result--;
        }
        
        return result;
    }
}

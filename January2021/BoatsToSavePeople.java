class Solution {
    // TC : O(nlogn)
    // SC : O(1)
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int end = people.length-1;
        int start =0;
        int boatCount =0;
        while(end>=start){
            if(people[end]==limit){
                end--;
                boatCount++;
            } else if(people[end]+ people[start] <=limit){
                start++;
                end--;
                boatCount++;
            } else {
                end--;
                boatCount++;
            }
        }
        return boatCount;
    }
}
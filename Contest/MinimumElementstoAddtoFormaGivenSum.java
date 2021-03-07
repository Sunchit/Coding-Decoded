class Solution {
    // TC : O(n)
    // SC : O(1)
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0; // Integer.MAX_VALUE
        for(int el: nums){
            sum += el;
        }

        long diffNeeded = Math.abs(goal - sum);

        if(diffNeeded % limit == 0){
            return (int)(diffNeeded /limit);
        } else{
            return (int)(diffNeeded /limit + 1);
        }

    }
}
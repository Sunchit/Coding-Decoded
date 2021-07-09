class Solution {

    // TC : O(nlogn)
    // SC: O(n)
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> bst = new TreeSet<>();
        for(int num: nums){
            Integer higherOrEqual = bst.ceiling(num);
            if(higherOrEqual == null){
                bst.add(num);
            } else{
                bst.remove(higherOrEqual);
                bst.add(num); // O(logn)
            }
        }

        return bst.size();
    }
}
// https://leetcode.com/problems/bitwise-ors-of-subarrays/
// @author: anuj0503
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        // Point 1:
        // Think of brute force.
        // You will find all possible subarrays like below then try to OR of all its elements
        // a[0] comes -> possible subarrays a[0]
        // a[1] comes -> possible subarrays a[1], {a[1], a[0]}
        // a[2] comes -> possible subarrays a[2], {a[2], a[1]}, {a[2], a[1], a[0]}
        // a[3] comes -> possible subarrays a[3], {a[3], a[2]}, {a[3], a[2], a[1]}, {a[3], a[2], a[1], a[0]}
        // So, basically whenever you encounter new elements, you will try to OR this element with possible subarrays in last steps.
        
        // Point 2
        // We want to do OR (not add), read carefully, we want to do OR and not addition.
        // And there are only 32 bits possible, so OR operation can set 32 bits at max.
        // Therefore, there can be at most 32 numbers in above each steps.
        // OR can set some bits at a time and those bits are at most 32 only.
        
        Set<Integer> result = new HashSet<>(); // contain all distinct OR result possible.
        Set<Integer> curr = new HashSet<>(); // Current set, means in this set we will add OR of current element with previous step ORs elements.

        curr.add(0);

        for(int i = 0; i < arr.length; i++){
            Set<Integer> runningSet = new HashSet<>();

            // For each of the subarray OR of previous step.
            for(int num : curr){
                // We are ORing with current elements and storing in different set.
                // We can't store in same set as that will give Concurrent Exception.
                runningSet.add(arr[i] | num);
            }

            // Adding that number itself.
            runningSet.add(arr[i]);

            // Current step will become previous step for next step
            curr = runningSet;
            result.addAll(curr);
        }

        return result.size();
    }
}

// https://leetcode.com/problems/maximum-segment-sum-after-removals/
// @author: anuj0503
class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        long[] result = new long[n]; // array to store answer
        long[] prefixSum = new long[n+1]; // array to store prefixSum of nums

        // calculating prefixSum
        for(int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        // TreeMap to store ranges to its sum mapping
        TreeMap<int[], Long> ranges = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        // initially it will have whole array range
        ranges.put(new int[]{0, n - 1}, prefixSum[n]);

        // TreeMap to store all the possible sums of range we encounter while solving queries, we are storing frequencies because 
        // multiple range can have same sum.
        TreeMap<Long, Integer> sums = new TreeMap<>();
        // initialise it with sum of all array.
        sums.put(prefixSum[n], 1);

        // Iterating on queries
        for(int i = 0; i < n; i++){
            int node = removeQueries[i]; // index to be removed or set to zero.

            // finding range which will split when node index is removed or set 0.
            int[] rangeToBeRemoved = ranges.floorKey(new int[]{node});
            Long sum = ranges.get(rangeToBeRemoved); // finding its sum

            // removing/ reducing sum from sums Map because we are splitting that range, so it is no more valid
            int f = sums.get(sum);
            if(f == 1) sums.remove(sum);
            else sums.put(sum, f - 1);

            // removing that range
            ranges.remove(rangeToBeRemoved);
            
            int l = rangeToBeRemoved[0];
            int r = rangeToBeRemoved[1];
            long newSum = 0;

            // Splitting range and store back new ranges form along with its sum.
            if (l == node && r != node) {
                newSum = prefixSum[r + 1] - prefixSum[l + 1];
                ranges.put(new int[]{l+1, r}, newSum);
                sums.put(newSum, sums.getOrDefault(newSum, 0) + 1);
            } else if (r == node && l != node) {
                newSum = prefixSum[r] - prefixSum[l];
                ranges.put(new int[]{l, r - 1}, newSum);
                sums.put(newSum, sums.getOrDefault(newSum, 0) + 1);

            } else if(node > l && node < r){
                newSum = prefixSum[node] - prefixSum[l];
                ranges.put(new int[]{l, node - 1}, newSum);
                sums.put(newSum, sums.getOrDefault(newSum, 0) + 1);

                newSum = prefixSum[r+1] - prefixSum[node + 1];
                ranges.put(new int[]{node + 1, r}, newSum);
                sums.put(newSum, sums.getOrDefault(newSum, 0) + 1);
            }


            if(sums.size() != 0)
                result[i] = sums.lastKey();
            else
                result[i] = 0;

        }

        return result;
    }
}

class Solution {
    TC : O(nlogn) SC: O(1)
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A); // O(nlogn)
        int len = A.length -1;
        int lowest = A[0];
        int highest = A[len];
        int res = highest - lowest;
        for(int i=0;i<len;i++){ //O(n)
            int min = Math.min(lowest + K, A[i+1] -K);
            int max = Math.max(highest -K, A[i]+K);
            res =  Math.min(max - min, res);
        }
        return res;
    }
}
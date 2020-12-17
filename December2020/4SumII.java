class 4SumII {

    //TC : O(n2)
    //SC : O(n2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count  =0 ;
        // sum, frequency
        Map<Integer, Integer> map = new HashMap<>();
        int len = A.length;
        for(int i =0 ;i<len;i++){
            for(int j=0;j<len;j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                int sum = C[i] +D[j];
                count += map.getOrDefault(-sum,0);

            }
        }
        return count;
    }
}
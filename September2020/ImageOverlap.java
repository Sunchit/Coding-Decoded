class ImageOverlap.java {

    // O(n2)
    private int getMatchCount(int[][] A, int[][] B, int startAI, int startAJ){
        int len = A.length;
        int count = 0;
        int startBI =0;
        int startBJ =0;

        for(int i=startAI;i<len;i++){
            startBJ =0;
            for(int j=startAJ;j<len;j++){
                if(A[i][j]==1 && A[i][j]== B[startBI][startBJ]){
                    count++;
                }
                startBJ++;
            }
            startBI++;
        }
        return count;
    }

    // O(n4)
    public int largestOverlap(int[][] A, int[][] B) {

        int maxCount = 0;
        int len = A.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                // Sliding window params i,j
                // A as sliding matrix B fixed
                maxCount = Math.max(maxCount, getMatchCount(A, B, i,j));

                // B as sliding matrix A fixed
                maxCount = Math.max(maxCount, getMatchCount(B, A, i,j));
            }
        }
        return maxCount;

    }
}
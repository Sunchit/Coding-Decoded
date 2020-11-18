class Solution {
    private int shiftRightDown(int[][] A, int[][] B, int xShift, int yShift, int N) {
//i represents row i.e towards y axis
//j represents column i.e towards x axis
        int count = 0;
        for (int i = yShift; i < N; i++) {

            for (int j = xShift; j < N; j++) {
                if (A[i][j] == 1 && B[i - yShift][j - xShift] == 1)
                    count++;
            }
        }
        return count;
    }

    private int shiftRightUp(int[][] A, int[][] B, int xShift, int yShift, int N) {
        int count = 0;
        for (int i = yShift; i < N; i++) {
            for (int j = 0; j < N - xShift; j++) {
                if (A[i][j] == 1 && B[i - yShift][j + xShift] == 1)
                    count++;
            }
        }
        return count;
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int maxCount = 0;
        int N = A.length;
        //xShift & yShift will be equivalent to the starting row, col of the sliding matrix over fixed matrix
        //i.e (1,0) the overlap started between
        //1st Matrix moving, 2nd fixed
        for (int yShift = 0; yShift < N; yShift++) {
            for (int xShift = 0; xShift < N; xShift++) {
                maxCount = Math.max(maxCount, shiftRightDown(A, B, xShift, yShift, N));
                maxCount = Math.max(maxCount, shiftRightDown(B, A, xShift, yShift, N));
                maxCount = Math.max(maxCount, shiftRightUp(A, B, xShift, yShift, N));
                maxCount = Math.max(maxCount, shiftRightUp(B, A, xShift, yShift, N));
            }
        }

        return maxCount;
    }

}
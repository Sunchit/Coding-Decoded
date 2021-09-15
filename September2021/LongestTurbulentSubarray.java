class Solution {
    public int maxTurbulenceSize(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int max = 1;
        int start = 0;
        int end = 0;

        while (start < A.length - 1) {
            if (A[start] == A[start+1]) {
                start++;
                continue;
            }
            end = start+1;
            while (end+1 < A.length && isTurbulent(A, end)) {
                end++;
            }

            System.out.println(start + " "+end);
            max = Math.max(max, end-start+1);
            start = end;
        }
        return max;
    }

    private boolean isTurbulent(int[] A, int k) {
        return (A[k] > A[k-1] && A[k] > A[k+1]) || (A[k] < A[k-1]) && (A[k] < A[k+1]);
    }
}
class Solution {
    // TC : O(m*n) SC: O(1)
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int top =0;
                int left = 0;
                int topLeft = 0;
                if(i>0){
                    top  = matrix[i-1][j];
                }

                if(j>0){
                    left  = matrix[i][j-1];
                }

                if(i>0 && j>0){
                    topLeft = matrix[i-1][j-1];
                }
                matrix[i][j] = top ^ left ^ topLeft ^ matrix[i][j];
                pq.offer(matrix[i][j]);
                if(pq.size()>k){ //
                    pq.poll();
                }

            }

        }
        return pq.peek();
    }
}
class Solution {
    // TC mlogk + mlogn
    // SC k
    public int[] kWeakestRows(int[][] mat, int k) {

        Comparator<int[]> customCompare = new Comparator<int[]>(){

            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                } else{
                    return b[0] - a[0];
                }
            }
        };
        // <1s count, row index>
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(customCompare); // k

        for(int i=0;i<mat.length;i++){

            int[] row = mat[i];
            //
            int countOnes =getCount(row);

            pq.offer(new int[]{countOnes, i});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int i = k-1;
        while(!pq.isEmpty()){
            ans[i]= pq.poll()[1];
            i--;
        }
        return ans;
    }

    private int getCountLinear(int[] row){
        int count =0;
        for(int el: row){
            if(el==1){
                count++;
            }
        }
        return count;
    }

    // log(n)
    private int getCount(int[] row){
       int low = 0;
        int high  = row.length;
        while(low<high){

            int mid = low+ (high -low)/2;
            if(row[mid] == 1){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }


}
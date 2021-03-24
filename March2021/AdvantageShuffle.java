class Solution {

    // TC : O(nlogn)
    // SC : O(n)
    public int[] advantageCount(int[] A, int[] B) {
        int len = A.length;
        int[] ans = new int[len];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> ((a,b) -> (b[1] - a[1]));

        for(int i=0;i<len;i++){
            pq.offer(new int[] {i, B[i]});
        }


        int low = 0;
        int high = len-1;
        Arrays.sort(A);
        while(!pq.isEmpty()){
            int[] head= pq.poll();
            int maxValueInB = head[1];
            int indexInB= head[0];

            if(A[high] > maxValueInB){
                ans[indexInB] = A[high];
                high--;
            } else {
                // maxValueInB > = A[high]
                ans[indexInB] = A[low];
                low++;
            }

        }

        return ans;
    }
}
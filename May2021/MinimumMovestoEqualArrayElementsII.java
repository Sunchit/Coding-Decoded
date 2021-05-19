class Solution {


    // TC : O(nlogn)
    // SC : O(1)
     public int minMoves2(int[] nums) {

         Arrays.sort(nums);

         int len = nums.length;
         int medianEl = nums[len/2];

         int count = 0;

         for(int el: nums){
             count += Math.abs(el-medianEl);
         }
         return count;
     }


    // TC : O(nlogn)
    // SC : O(n)
    public int minMoves2(int[] nums) {

        PriorityQueue<Integer> pq =new PriorityQueue<Integer>(); // MIN heap

        int len = nums.length;


        for(int i=0;i<nums.length;i++){
            if(pq.size()<=len/2){
                pq.offer(nums[i]);
            } else if(nums[i] > pq.peek()){
                pq.poll();

                pq.offer(nums[i]);
            }
        }

        int medianEl = pq.peek();
        int count = 0;

        for(int el: nums){
            count += Math.abs(el-medianEl);
        }
        return count;
    }
}
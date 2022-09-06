// https://leetcode.com/problems/find-the-k-sum-of-an-array/
// @author: anuj0503
class Solution {
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += ((nums[i] > 0)?nums[i]:0);
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);
        
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Long, Integer>>() {
            @Override
            public int compare(Pair<Long, Integer> o1, Pair<Long, Integer> o2) {
                return Long.compare(o2.getKey(), o1.getKey());
            }
        });
        
        long result = sum;
        pq.offer(new Pair<>(sum - nums[0], 0));
        
        while (--k > 0){
            Pair<Long, Integer> head = pq.poll();
            result = head.getKey();
            int index = head.getValue();
            
            if(index < n - 1){
                pq.offer(new Pair<>(result - nums[index + 1], index + 1));
                pq.offer(new Pair<>(result + nums[index] - nums[index + 1], index + 1));
            }
        }
        
        return result;
    }
}

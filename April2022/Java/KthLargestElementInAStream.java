
// @saorav21994
// TC : O(nlogk + mlogk)
// SC : O(k)

class KthLargest {
    
    PriorityQueue<Integer> queue;
    int maxLimit;
    
    public KthLargest(int k, int[] nums) {
        
        this.queue = new PriorityQueue<>();  // min-heap
        this.maxLimit = k;
        
        // restrict priority queue upto maxLimit size. top element will be answer.
        
        for (int i = 0; i < nums.length; i++) {
            if (k > 0) {
                queue.offer(nums[i]);
                k -= 1;
            }
            else {
                if (nums[i] > queue.peek()) {
                    int getOut = queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        
    }
    
    public int add(int val) {
        
        if (queue.size() < maxLimit) {
            queue.offer(val);
        }
        else if (val > queue.peek()) {
            int getOut = queue.poll();
            queue.offer(val);
        }
        
        return queue.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

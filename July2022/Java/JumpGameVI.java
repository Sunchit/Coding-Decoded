
// @saorav21994
// TC : O(n)
// SC : O(k)

class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(nums[0]);    // tail, or rear
        for (int i = 1; i < n; i++) {
            int max = dq.peek();    // head, or front
            nums[i] += max;
            
            // remove element beyond reach of k;
            // at each step only 1 element max needs to be removed, so if condition is fine
            // 2nd condition is because it might happen that we have already removed that element in the while loop
            if (i-k >= 0 && dq.peek() == nums[i-k]) {
                dq.removeFirst();   // head, or front
            }
            
            // only keep the max element at the rear from where we are adding to ans
            while (dq.isEmpty() == false && nums[i] > dq.peekLast()) {
                dq.pollLast();  // from rear
            }
            dq.add(nums[i]);    // to rear
        }   
        return nums[n-1];
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // K

        int[] ans = new int[nums.length -k +1];
        int j =0;
        for(int i=0;i<nums.length;i++){
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0)+1);

            if(i >=k-1){
                ans[j] = treeMap.lastKey();
                j++;

                // i -k +1
                treeMap.put(nums[i-k+1], treeMap.get(nums[i-k+1]) -1);

                if(treeMap.get(nums[i-k+1]) == 0){
                    treeMap.remove(nums[i-k+1]);
                }
            }
        }
        // TC : O(nlogk)
        // SC : O(n-k)
        return ans;
    }
}

=============== Solution Using Deque==================
// https://leetcode.com/problems/sliding-window-maximum/
// @author: anuj0503
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        
        // This deque will be having only indices of the current window size
        // for eg: for index i, then deque will have indices t - k + 1 to t (notice: backward from current index)
        // Also, first peek element of the deque will be index of number having the maximum value of that window
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){
            int firstIndexOfWindow = i - k + 1;
            // If front peek element of deque get out of range of current window [i - k + 1, i]
            // then remove those.
            while(!dq.isEmpty() && dq.peekFirst() < firstIndexOfWindow){
                dq.pollFirst();
            }

            // If we encounter any number which is greater than last elements of deque,
            // those elements are pf no use as we have got a new maximum, so remove those.
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            dq.offer(i);

            // for first k element we will do nothing in our result array.
            if(i >= k - 1){
                result[index++] = nums[dq.peekFirst()];
            }
        }


        return result;
    }
}

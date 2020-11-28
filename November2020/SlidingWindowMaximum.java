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
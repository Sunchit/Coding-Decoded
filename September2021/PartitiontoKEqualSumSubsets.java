class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for(int el: nums){
            total+=el;
        }

        if(total%k !=0){
            return false;
        }

        if (nums.length < k) return false;

        int subsetSum = total/k;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, subsetSum);

    }

    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int curSum, int subsetSum) {
        if (k == 0) return true;
        if (curSum > subsetSum) return false;
        if (curSum == subsetSum)  {
            return canPartition(nums, visited, 0, k - 1, 0, subsetSum);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (canPartition(nums, visited, i + 1, k, curSum + nums[i], subsetSum)) return true;
            visited[i] = false;
        }

        return false;
    }
}




class Solution {
    
    // TC: O(n)
    // SC : O(n)
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int el: nums){
            totalSum += el;
        }
        int target = totalSum - x;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLenSubArray = -1;
        int prefixSum = 0;
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            map.put(prefixSum, i);
            if(map.containsKey(prefixSum - target)){
                int currLenSubArray = i - map.get(prefixSum - target);
                maxLenSubArray = Math.max(maxLenSubArray, currLenSubArray);
            }
        }
        
        if(maxLenSubArray == -1){
            return maxLenSubArray;
        } else{
            return nums.length - maxLenSubArray;
        }
    }
}
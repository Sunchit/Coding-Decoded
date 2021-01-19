class Solution {

    // TC: O(n2) SC: O(n2)
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int product = nums[i]*nums[j];
                int freq = map.getOrDefault(product, 0);
                map.put(product, freq+1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            ans += ((freq* (freq-1))*4);
        }
        return ans;
    }
}
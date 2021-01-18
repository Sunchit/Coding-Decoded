class Solution {

    // TC: O(nlogn) SC: O(1)
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start =0;
        int end = nums.length-1;
        int count = 0;
        while(start<end){
            int sum = nums[start]+ nums[end];
            if(sum>k){
                end--;
            } else if(sum<k) {
                start++;
            } else{
                // sum ==k
                end--;
                start++;
                count++;
            }
        }
        return count;
    }


    // TC: O(n) SC: O(n)
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map =new HashMap<>();
        int count =0;
        for(int el: nums){
            if(map.containsKey(k- el)){
                int freq = map.get(k- el);
                if(freq ==1){
                    map.remove(k-el);

                } else {
                    map.put(k-el, freq-1);
                }
                count++;
            } else{
                map.put(el, map.getOrDefault(el, 0)+1);
            }
        }
        return count;
    }

}
class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        List<Integer> doubleDiff = new ArrayList<>();
        for(int num: nums){
            int doubeK  = num - nums[0];

            // 2K is always even in nature
            if(doubeK >0 && doubeK%2==0) doubleDiff.add(doubeK);
        }
        for(int doubleK: doubleDiff){
            List<Integer> arr = checkDiff(nums, doubleK);
            if(arr.size()==nums.length/2){
                return arr.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return new int[]{};

    }
    private List<Integer> checkDiff(int[] nums, int doubleDiff){
        Map<Integer, Integer> freq = new HashMap<>();
        for(int el :nums){
            freq.put(el, freq.getOrDefault(el,0)+1);
        }
        /// original array
        List<Integer> ans = new ArrayList<>();
        for(int num :nums){
            // num = A - K              A-K + DoubleDiff = A +K
            if(freq.get(num) > 0 &&  freq.getOrDefault(num+doubleDiff,0) > 0){
                // num = A - k  + 2k/2 = A
                ans.add(num + doubleDiff / 2);

                freq.put(num, freq.get(num)-1);

                freq.put(num+doubleDiff, freq.get(num + doubleDiff)-1);
            }
        }
        return ans;
    }
}
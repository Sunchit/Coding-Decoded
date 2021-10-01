class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        set.add(new ArrayList<>());
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; ++i) {
            int size = result.size();
            for (int j = 0; j < size; ++j) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                if (!set.contains(temp)) {
                    result.add(temp);
                    set.add(temp);
                }
            }
        }
        
        return result;
    }
}

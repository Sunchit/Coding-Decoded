class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;

            if(nums[index]<0){
                ans.add(index+1);
            }
            nums[index] = -nums[index];
        }
        return ans;
    }
}
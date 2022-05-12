class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;

        List<List<Integer>> ans=new ArrayList<>();

        Set<List<Integer>> setAns=new HashSet<>();

        boolean[] visited=new boolean[n];

        backtracking(nums, setAns, visited, new ArrayList<>());


        for(List<Integer> e: setAns){
            ans.add(e);
        }

        return ans;
    }

    private void backtracking(int[] nums,Set<List<Integer>> res,boolean[] visited,List<Integer> subList){

        if(subList.size()==nums.length){
            res.add(new ArrayList<>(subList));
        }

        for(int i=0;i<nums.length;i++){
          if(!visited[i]) {
              subList.add(nums[i]);
              visited[i] = true;
              backtracking(nums, res, visited, subList);
              visited[i] = false;
              subList.remove(subList.size()-1);
          }

        }
    }
}
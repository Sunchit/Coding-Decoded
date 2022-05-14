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


// @saorav21994
// Without using extra space for hashset/hashmap and using sort function. Extra nlog(n) TC but it does not matter in front of n.n! for TC 

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean [] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, visited, res, new ArrayList<Integer>());
        return res;
    }
    
    public void permute(int [] nums, boolean [] visited, List<List<Integer>> res, ArrayList<Integer> cur) {
        
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
                       
            if (i != 0 && nums[i] == nums[i-1] && visited[i-1]) {
                continue;
            }
            
            else {
                if (!visited[i]) {
                    cur.add(nums[i]);
                    visited[i] = true;
                    permute(nums, visited, res, cur);
                    visited[i] = false;
                    cur.remove(cur.size()-1);
                }
            }
        }
        
    }
}

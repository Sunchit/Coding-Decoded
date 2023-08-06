// Author: Mahesh Reddy B N
// Problem Link: https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        helper(ls,al,nums,0);
        return ls;
    }
    public void helper(List<List<Integer>> ls, List<Integer> al,int[] nums,int count){
        if(count>= nums.length){
            ls.add(new ArrayList<>(al));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-11){
                al.add(nums[i]);
                nums[i] = -11;
                helper(ls,al,nums,count+1);
                nums[i] =  al.remove(al.size()-1);
            }
        }
    }
}
// AUthor: Mahesh Reddy B N
// Problem Link: https://leetcode.com/problems/combinations/description/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i<=n;i++){
            nums.add(i);
        }
        List<Integer> al = new ArrayList<>();
        helper(ls,al,nums,0,k);
        return ls;
    }
    public void helper( List<List<Integer>> ls, List<Integer> al,List<Integer> nums,int si,int count){
        if(count<=0){
            ls.add(new ArrayList<>(al));
            return;
        }
        if(si>=nums.size()) return;
        al.add(nums.get(si));
        helper(ls,al,nums,si+1,count-1);
        al.remove(al.size()-1);
        helper(ls,al,nums,si+1,count);
    }
}
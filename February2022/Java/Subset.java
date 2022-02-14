//Author Shobhit Behl(LC:shobhitbruh)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> al=new ArrayList<>();
        rec(al,ans,nums,nums.length-1);
        
        return ans;
    }
    
    public void rec(List<Integer> al,List<List<Integer>> ans,int[] nums,int i){
        if(i==-1){
            List<Integer> ak=new ArrayList<>();
            for(int j=0;j<al.size();j++){
                ak.add(al.get(j));
            }
            ans.add(ak);
            return;
        }
        
        rec(al,ans,nums,i-1);
        al.add(nums[i]);
        rec(al,ans,nums,i-1);
        al.remove(al.size()-1);
        
        
    }
}
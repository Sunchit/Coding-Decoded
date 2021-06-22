class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<numRows;i++){
            ans.add(pascalTriangle2(i));
        }
        return ans;
        
    }
    public static ArrayList<Integer> pascalTriangle2(int r){
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        int i=r;
        int val=1;
        
        //(i-j)/(j+1) is the factor need to multiply with current value to get the next value.
        for(int j=0;j<=r;j++){
            ans.add(val);
            val=val*(i-j)/(j+1);
        }
      
        return ans;
    }
}

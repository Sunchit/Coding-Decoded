class Solution {


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        //
        int row = 1;
        List<Integer> subList = new ArrayList<>();
        subList.add(1);
        ans.add(subList);

        while(row<numRows){
            List<Integer> previousList = ans.get(row-1);
            List<Integer> newList = new ArrayList<>();
            for(int i=0;i<=row;i++){
                int leftEntry = i>=1 ? previousList.get(i - 1) :0;
                int rightEntry = i<row ? previousList.get(i) :0;
                newList.add(leftEntry + rightEntry);

            }
            ans.add(newList);
            row++;

        }

        return ans;
    }
}
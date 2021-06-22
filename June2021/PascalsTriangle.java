
// https://leetcode.com/problems/pascals-triangle/

//Soltion 1 @Coding Decoded
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

// Solution 2 Thanks @theankitroy

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<numRows;i++){
            ans.add(pascalTriangle2(i));
        }
        return ans;

    }

    // Logic explanation : https://github.com/Sunchit/Coding-Decoded/blob/master/June2021/img/PascalsTriangleCombinationApproach.png
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

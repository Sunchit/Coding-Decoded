
// @saorav21994
// TC: O(n*(n-1)) = O(n^2)
// SC: O(n^2) - output

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            int n = 1;
            for (int j = 1; j <= i; j++) {
                tmp.add(n);
                n = n*(i-j)/j;
            }
            res.add(tmp);
        }
        return res;
    }
}

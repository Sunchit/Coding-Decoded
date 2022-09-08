// https://leetcode.com/problems/xor-queries-of-a-subarray/submissions/
// @author: anuj0503
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        Map<Integer, Integer> prefixXOR = new HashMap<>();
        prefixXOR.put(-1, 0);
        int xor = 0;
        for(int i = 0; i < n; i++){
            xor ^= arr[i];
            prefixXOR.put(i, xor);
        }
        
        int q = queries.length;
        int[] result = new int[q];
        for(int i = 0; i < q; i++){
            result[i] = prefixXOR.get(queries[i][1]) ^ prefixXOR.get(queries[i][0] - 1);
        }
        
        return result;
    }
}

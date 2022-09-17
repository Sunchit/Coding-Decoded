
// @saorav21994
// TC : O(n*sqrt(n))
// SC : O(n)

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        /*
            dp[root] = dp[lchild] * dp[rchild];
            We need to sort the array, so that we have all possible factor before the number itself.
            So if any arr[i] (= root) is divisible by arr[j] (= lchild), find if arr[k] (= rchild) exists or not in arr[...]. Can use map for that.
            Sum of all possible trees in dp[...] = answer.
            O(n^2)
            
            Optimisation ::
            We know that to find all factor of a number (which we are finding over here), we need to iterate to max the sqrt(number).
            If the factor are different, since we are searching tree, we multiply by 2 as left and right child if have diff. values, can form 2 diff. trees. Else the multiplier will be 1.
            O(n*sqrt(n)
            
        */
        
        int MOD = 1000000007;
        int n = arr.length;
        Arrays.sort(arr);

        // (number, factors)
        Map<Integer, Long> map = new HashMap<>();
        
        long res = 0l;
        
        for (int i = 0; i < n; i++) {
            
            int limit = (int)(Math.sqrt(arr[i]));
            int root = arr[i];
            long factors = 1l;
            for (int k = 0, j = arr[0]; j <= limit; k += 1, j = arr[k]) {

                int lchild = j;
                if (root%lchild == 0) {     // root is divisible by lchild, then find rchild
                    int rchild = root/lchild;
                                    
                    if (map.containsKey(rchild)) {     // rchild exits in our map, and tree can be constructed
                        int multiply = 2;
                        if (lchild == rchild)
                            multiply = 1;
                        factors = (factors + (map.get(lchild) * map.get(rchild) * multiply)%MOD)%MOD;
                    }
                }
            }
            
            map.put(root, factors);
            res = (res + factors)%MOD;
            
        }
        
        return (int) (res%MOD);
        
    }
}

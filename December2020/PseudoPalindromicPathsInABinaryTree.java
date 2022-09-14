class Solution {

    private int ans = 0;

    // TC : O(n)

    // SC : O(n) *10
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];

        helper(root, freq);
        return ans;
    }

    private void helper(TreeNode root, int[] freq){
        if(root== null){
            return ;
        }

        freq[root.val]++;

        if(root.left == null && root.right == null){
            // this is a leaf node
            if(isPalindromicPermutation(freq)){
                ans++;
            }
        }

        helper(root.left, freq);
        helper(root.right, freq);

        freq[root.val]--;

    }

    private boolean isPalindromicPermutation(int[] freq){
        boolean oddFreqFound = false;
        for(int el: freq){
            if(el%2!=0){
                if(oddFreqFound){
                    return false;
                } else{
                    oddFreqFound = true;
                }

            }
        }

        return true;
    }
}

================ Approach using Bit Masking =================
// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
// @author: anuj0503
class Solution {
    int result;
    Set<Integer> set;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        set = new HashSet<>();

        for(int i = 1; i <= 9; i++){
            set.add((int) Math.pow(2, i));
        }
        set.add(0);

        result = 0;

        getResult(root, 0);

        return result;
    }

    private void getResult(TreeNode root, int mask){
        if(root == null) return;

        if(root.left == null && root.right == null){
            if(set.contains(mask ^ (1 << root.val))) result++;
        } else {
            getResult(root.left, mask ^ (1 << root.val));
            getResult(root.right, mask ^ (1 << root.val));
        }
    }
}

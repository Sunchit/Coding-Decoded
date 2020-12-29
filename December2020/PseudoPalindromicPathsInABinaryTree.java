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
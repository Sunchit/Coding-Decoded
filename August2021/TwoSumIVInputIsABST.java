/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// TC : O(n)
// SC : O(n)
class Solution {
   public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return preorder(root, set, k);
    }

    public boolean preorder(TreeNode root, Set<Integer> set, int k){
        if(root == null)  {
          return  false;
        }
        int counterEl  = k - root.val;
        if(set.contains(counterEl)) {
            return true;
        }
        set.add(root.val);
        return preorder(root.left, set, k) || preorder(root.right, set, k);
    }
}

class Solution {
   public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int left =0;
        int right = nums.size()-1;
        while(left<right) {
            if(nums.get(right) + nums.get(left) == k)return true;
            if(nums.get(left) + nums.get(right) < k) {left++;}
            else { right--; }

        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> nums){
        if(root == null)return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

}
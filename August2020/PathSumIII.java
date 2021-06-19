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
class PathSumIII {

    private int count = 0;
    public int pathSum(TreeNode root, int sum) {

        if(root==null){
            return count;
        }
        postOrderTraversal(root, sum);
        return count;
    }

    private List<Integer> postOrderTraversal(TreeNode root, int sum) {
        if(root==null){
            return new ArrayList<>();
        }

        List<Integer> leftList = postOrderTraversal(root.left, sum);


        List<Integer> rightList = postOrderTraversal(root.right, sum);

        List<Integer> currList = new ArrayList<>();

        // Iterate through the leftList and add root.val to each el
        for(Integer leftChild : leftList){
            currList.add(leftChild + root.val);
        }


        // Iterate through the leftList and add root.val to each el
        for(Integer rightChild : rightList){
            currList.add(rightChild + root.val);
        }

        // adding root.val in currList

        currList.add(root.val);

        for(Integer el: currList){
            if(el == sum){
                count++;
            }
        }
        return currList;
    }
}
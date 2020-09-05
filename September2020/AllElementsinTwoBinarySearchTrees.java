
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
class AllElementsinTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        inorderTraversal(root1, list1); // O(n1)

        List<Integer> list2 = new ArrayList<>();
        inorderTraversal(root2, list2); //O(n2)

        return merge(list1, list2); // O(n1+n2) => O(no of el in both the trees)

    }
    // All the elements are travered once in both the lists => O(n1 + n2)
    private List<Integer> merge(List<Integer> list1, List<Integer> list2){
        List<Integer> ans = new ArrayList<>();
        int start1 = 0;
        int start2 = 0;
        int len1 = list1.size();
        int len2 = list2.size();

        while(start1 <len1 && start2 <len2){
            if(list1.get(start1) < list2.get(start2)){
                ans.add(list1.get(start1));
                start1++;
            } else{
                ans.add(list2.get(start2));
                start2++;
            }
        }

        while(start2 <len2){

            ans.add(list2.get(start2));
            start2++;

        }

        while(start1 <len1){

            ans.add(list1.get(start1));
            start1++;

        }
        return ans;

    }

    // All the elements are travered once in the tree => O(n)
    private void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return ;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);

        inorderTraversal(root.right, list);
    }
}
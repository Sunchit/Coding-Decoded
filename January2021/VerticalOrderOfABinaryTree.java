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
class Solution {
    private class Point{
        int x;
        int y;
        int val;

        Point(int val, int x, int y){
            this.val= val;
            this.x =x;
            this.y =y;
        }
    }

    PriorityQueue<Point> pq =new PriorityQueue<Point>((a,b) -> {
        if(a.x !=b.x){
            return a.x - b.x; // lower x
        } else{
            if(a.y!=b.y){
                return b.y -a.y;// higher y
            } else{
                return a.val - b.val; // lower val
            }
        }
    });


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        treeTraversal(root, 0, 0);
        Integer prevXIndex = null;
        List<Integer> subArray = new ArrayList<>();
        while(!pq.isEmpty()){
            Point head = pq.poll();
            if(prevXIndex!= null && head.x!=prevXIndex){
                res.add(subArray);
                subArray =new ArrayList<>();
            }
            subArray.add(head.val);
            prevXIndex = head.x;
        }
        if(subArray.size()>0){
            res.add(subArray);
        }

        return res;
    }

    private void treeTraversal(TreeNode root, int x, int y){
        if(root == null){
            return;
        }
        pq.offer(new Point(root.val, x, y));
        treeTraversal(root.left, x-1, y-1);
        treeTraversal(root.right, x+1, y-1);
    }
}
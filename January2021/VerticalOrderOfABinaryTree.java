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

============== Another Approach using TreeMap ===========================
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// @author: anuj0503
class Solution {
    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> columnMapping;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        columnMapping = new TreeMap<>();

        helper(0, 0, root);

        for(Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> entry1 : columnMapping.entrySet()){
            ArrayList<Integer> r = new ArrayList<>();
            for(Map.Entry<Integer, ArrayList<Integer>> entry2 : entry1.getValue().entrySet()){
                ArrayList<Integer> al = entry2.getValue();
                Collections.sort(al);

                r.addAll(al);
            }

            result.add(r);
        }

        return result;
    }

    private void helper(int row, int column, TreeNode root){
        if(root == null) return;

        TreeMap<Integer, ArrayList<Integer>> treeMap = columnMapping.getOrDefault(column, new TreeMap<>());
        ArrayList<Integer> al = treeMap.getOrDefault(row, new ArrayList<>());
        al.add(root.val);
        treeMap.put(row,al);
        columnMapping.put(column, treeMap);

        helper(row + 1, column - 1, root.left);
        helper(row + 1, column + 1, root.right);
    }
}

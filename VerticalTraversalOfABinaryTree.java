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

    // Point Class definition
    private class Point{
        private int x;
        private int y;
        private int val;
        public Point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;

        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        List<Point> points = new ArrayList<>();
        dfs(root, 0, 0, points);

        // sort the points
        Collections.sort(points, (p1, p2) ->((p1.x==p2.x) ? (p1.y==p2.y) ? p1.val - p2.val : p2.y -p1.y : p1.x - p2.x));

        // X coordinate , List<Integer> for storing values
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();

        for(Point p: points){
            List<Integer> verticalLine = treeMap.getOrDefault(p.x, new ArrayList<>());
            verticalLine.add(p.val);
            treeMap.put(p.x, verticalLine);
        }

        return new ArrayList<>(treeMap.values());

    }

    private void dfs(TreeNode root, int x, int y, List<Point> points){
        if(root==null){
            return ;
        }
        points.add(new Point(x, y, root.val));
        dfs(root.left, x-1, y-1, points);
        dfs(root.right, x+1, y-1, points);
    }
}
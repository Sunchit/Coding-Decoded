// Author Shobhit Behl( LC : shobhitbruh)
class Solution {
    public static class Pair {
    TreeNode node;
    int st = 0;

    Pair(TreeNode node, int st) {
      this.node = node;
      this.st = st;
    }
  }
    public int widthOfBinaryTree(TreeNode root) {
            LinkedList<Pair> pa = new LinkedList<>();
    pa.addLast(new Pair(root, 0));
    int max = 0;
    boolean f = false;
    while (pa.size() > 0 ) {
      int size = pa.size();
      int first = pa.getFirst().st;
      int last = pa.getFirst().st;
      while (size-- > 0) {
        Pair rem = pa.removeFirst();
        last = rem.st;
        if (rem.node.left != null) {
          pa.addLast(new Pair(rem.node.left, (2 * rem.st) + 1));
        }
        if (rem.node.right != null) {
          pa.addLast(new Pair(rem.node.right, (2 * rem.st) + 2));
        }
      }
      max = Math.max(max, last - first + 1);
    }

    return max;
    //BFS using single linkedlist.
    }
}
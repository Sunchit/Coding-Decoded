public class NumArray {

    class SegmentTreeNode {
        private int start, end;
        private  SegmentTreeNode left, right;
        private  int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    // TC : O(n)
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start]; // leaf nodes
            } else {
                int mid = start  + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    // TC : O(logn)
    void update(int i, int val) {
        updateHelper(root, i, val);
    }

    void updateHelper(SegmentTreeNode root, int pos, int val) {
        // found leaf node to be updated
        if (root.start == root.end) {
            root.sum = val;
        } else {
            // parent nodes across the path
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {

                updateHelper(root.left, pos, val);
            } else {
                updateHelper(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }

    // TC : O(logn)
    public int sumRangeHelper(SegmentTreeNode root, int start, int end) {
        // if you found out the node that matches your search return its value
        if (root.start == start && root.end == end ) {
            return root.sum;
        } else {

            int mid = root.start + (root.end - root.start) / 2; // overflow conditions
            if (end <= mid) {
                // move left
                return sumRangeHelper(root.left, start, end);
            } else if (start >= mid+1) {
                // move right
                return sumRangeHelper(root.right, start, end);
            }  else {
                // consider both nodes
                return  sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid+1, end) ;
            }
        }
    }
}
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

    private  int cameraCount = 0;

    private int NEEDS_CAMERA = 0;
    private int HAS_CAMERA = 1;
    private int COVERED = 2;
    private int NOT_NEEDED = 3;


    // TC : O(n)
    // SC : log(n)
    public int minCameraCover(TreeNode root) {

        cameraCount = getCameraStatusForEachNode(root) == NEEDS_CAMERA?cameraCount+1: cameraCount ;
        return cameraCount;
    }

    // LRI

    private int getCameraStatusForEachNode(TreeNode root){
        if(root == null){
            return NOT_NEEDED;
        }
        // leaf
        if(root.left == null && root.right == null){
            return NEEDS_CAMERA;
        }

        int leftStatus =getCameraStatusForEachNode(root.left);
        int rightStatus = getCameraStatusForEachNode(root.right);

        if(leftStatus == NEEDS_CAMERA || rightStatus == NEEDS_CAMERA){
            cameraCount++;
            return HAS_CAMERA;
        }

        if(leftStatus == HAS_CAMERA || rightStatus == HAS_CAMERA){
            return COVERED;
        }

        return NEEDS_CAMERA;
    }
}
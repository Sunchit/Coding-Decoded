class Solution {

    private TreeNode root = null;
    private int indexInPreorder = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0|| inorder.length==0){
            return null;
        }

        root = buildTreeHelper(preorder, inorder, 0 ,inorder.length-1);
        return root;
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int startInorder, int endInorder){
        if(indexInPreorder>=preorder.length){
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[indexInPreorder]);

        int indexInOrder = indexInInorder(inorder, startInorder, endInorder, preorder[indexInPreorder]);

        if(indexInOrder==-1){
            // Null
            return null;
        }

        indexInPreorder++;

        newNode.left = buildTreeHelper(preorder, inorder, startInorder, indexInOrder-1);

        newNode.right = buildTreeHelper(preorder, inorder, indexInOrder+1, endInorder);


        return newNode;
    }

    private int indexInInorder(int[] inorder, int start, int end, int no){
        while(start<=end){
            if(no==inorder[start]){
                return start;
            }
            start++;
        }
        return -1;

    }
}


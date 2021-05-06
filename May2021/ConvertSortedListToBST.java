
// Solution for 108 Convert Sorted Array to BST
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }

        return helper(nums, 0, nums.length-1);


    }

    private TreeNode helper(int[] nums, int startIndex, int endIndex){
        if(startIndex> endIndex){
            return null;
        }

        int midIndex = (startIndex + endIndex)/2;

        TreeNode newNode = new TreeNode(nums[midIndex]);

        newNode.left = helper(nums, startIndex, midIndex-1);
        newNode.right = helper(nums, midIndex+1, endIndex);

        return newNode;
    }
}

// Solution for 109 Convert sorted list to BST
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }

         return helper(head, null);
    }

    private TreeNode helper(ListNode start, ListNode end){
        ListNode fast =start;
        ListNode slow = start;
        if(start == end) {
            return null;
        }

        while(fast!=end && fast.next!=end){
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode newNode = new TreeNode(slow.val);

        newNode.left = helper(start, slow);
        newNode.right = helper(slow.next, end);

        return newNode;

    }

}
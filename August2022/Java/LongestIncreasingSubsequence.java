
// @saorav21994
// TC : O(nlogn)
// SC : O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        // This is an approach based on solitaire game rules.
        // TC - O(nlogn). TreeSet based implementation (BST in java)
        // ArrayList<> shifting is O(n) so using that with binary search won't reduce TC to O(nlogn)
        // TreeSet = self balancing BST, so, add, remove, search = O(logn)
        TreeSet<Integer> bst = new TreeSet<Integer>();
        for (int num : nums) {
            // find least >= element than current number
            Integer ceil = bst.ceiling(num);
            // System.out.println("num = " + num + " ceil = " + ((ceil == null) ? "NULL" : ceil));
            if (ceil != null) {
                bst.remove(ceil);
            }
            bst.add(num);
        }
        return bst.size();
    }
}

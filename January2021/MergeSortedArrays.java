class Solution {

    // TC: O(m+n)
    // SC: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int e1 = nums1.length-1;
        while(e1>=0){
            int firstEl = p1>=0 ? nums1[p1] : Integer.MIN_VALUE;
            int secondEl = p2>=0 ? nums2[p2] : Integer.MIN_VALUE;
            if(firstEl>secondEl){
                nums1[e1] = firstEl;
                p1--;
                e1--;
            } else{
                nums1[e1] = secondEl;
                p2--;
                e1--;
            }
        }

    }
}
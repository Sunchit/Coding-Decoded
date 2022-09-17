// class Solution {
//     // O(right- left)
//     public int rangeBitwiseAnd(int left, int right) {
//      int ans = left;
//         for(int i=left;i<=right;i++){
//             ans = ans &i;
//         }
//         return ans;
//     }
// }

class Solution {
    // TC : O(32)
    public int rangeBitwiseAnd(int left, int right) {
        int shiftCount = 0;
        while(left!=right) {
            left >>= 1;
            right>>= 1;
            shiftCount++;
        }
        return left << shiftCount;
    }
}
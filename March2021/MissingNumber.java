class Solution {

    // Sum approach TC: O(n)
    // SC : O(1)
    public int missingNumber(int[] nums) {
        int total = 0;
        for(int el: nums){
            total += el;
        }
        int n = nums.length;
        return ((n)*(n+1))/2 - total;
    }

    // XOR approach
    public int missingNumber(int[] nums) {
        int xorAll = 0;
        for(int el: nums){
            xorAll = xorAll ^ el;
        }
        int xorActual = 0;
        for(int i=1;i<=nums.length;i++){
            xorActual = xorActual ^ i;
        }

        return xorActual ^ xorAll;
    }
}
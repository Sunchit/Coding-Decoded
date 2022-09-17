class Solution {
    // TC : O(n)
    // SC : O(1)
    public int[] sortArrayByParityII(int[] nums) {
        int oddNoAtEvenIndex= 0;
        int evenNoAtOddIndex = 1;
        int n = nums.length;
        while (oddNoAtEvenIndex < n && evenNoAtOddIndex < n) {
            while (oddNoAtEvenIndex < n && nums[oddNoAtEvenIndex] % 2 == 0) {
                oddNoAtEvenIndex += 2;
            }
            while (evenNoAtOddIndex < n && nums[evenNoAtOddIndex] % 2 == 1) {
                evenNoAtOddIndex += 2;
            }
            if (evenNoAtOddIndex < n && oddNoAtEvenIndex < n) {
                swap(nums, oddNoAtEvenIndex, evenNoAtOddIndex);
            }
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        if(i!=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
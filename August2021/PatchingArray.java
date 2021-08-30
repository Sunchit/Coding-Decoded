class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int i = 0;
        long reach = 0;
        while(reach<n) {

            if (i>=nums.length) {
                // keep on adding the lowest no
                System.out.println("El to be patched "+ (reach+1));
                reach += reach+1;
                count++;
            }
            else if(i < nums.length && nums[i] <= (reach+1)) {
                reach += nums[i];
                i++;
            } else {
                System.out.println(" El missing, hence patching "+ (reach+1));
                reach += reach+1;
                count++;

            }

        }
        return count;
    }
}
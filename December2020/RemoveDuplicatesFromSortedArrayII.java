class RemoveDuplicatesFromSortedArrayII {

    // TC O(n), SC O(1)
    public int removeDuplicates(int[] nums) {
        int oIndex = 0;
        int i = 0; // Index upto which repetition happens
        while(i<nums.length){

            int sIndex = i; //// Start Index of repetition
            while(i<nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }

            int length = i -sIndex +1; // Length of repetition
            int freq = Math.min(length, 2);

            while(freq-->0){
                nums[oIndex] = nums[sIndex];
                oIndex++;
            }
            i++;
        }
        return oIndex;

    }
}
class Solution {

    // TC : O(N)
    // SC: O(1)
    public void nextPermutation(int[] nums) {
        int first = nums.length-1;


        while(first>=1 && nums[first-1] >=nums[first]){
            first--;
        }

        if(first==0){
            Arrays.sort(nums);
            return;
        }

        first--;

        int second = nums.length-1;

        while(first<second && nums[first] >=nums[second]){
            second--;
        }


        swap(nums, first, second);

        int start = first+1;
        int end = nums.length -1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end] ;
            nums[end] = temp;
            end--;
            start++;
        }
    }

    private void swap(int[] nums, int first, int second){
        if(first!=second){
            int temp = nums[second];
            nums[second] = nums[first];
            nums[first] = temp;
        }
    }
}
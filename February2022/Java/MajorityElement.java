

// @saorav212294

// TC - O(n)
// SC - O(1)

// If an element is majority it will beat out the combined frequency of the rest of the elements in the array


class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i])
                count += 1;
            else {
                count -= 1;
                if (count  < 0) {
                    count *= -1;
                    maj = nums[i];
                }
            }
        }
        return maj;
    }
}
class Solution {

	// TC : O(n)
	// SC :O(1)
	public int majorityElement(int[] nums) {
		int count = 1;
		int majorityEl = nums[0];
		for(int i=1;i<nums.length;i++) {
			int el = nums[i];
			if(el == majorityEl){
				count++;
			} else{
				count--;
			}
			if(count == 0){
				majorityEl = nums[i];
				count =1;
			}
		}

		return majorityEl;

	}
}

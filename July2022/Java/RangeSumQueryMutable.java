
// @saorav21994
// TC : O(nlogn)
// SC : O(n)

class NumArray {

    // Using BIT (Binary Indexed Tree) / Fenwick Tree
    
    int [] arr;
    int [] bit;
    int l;
    
    public NumArray(int[] nums) {
        
        l = nums.length;
        arr = new int[l];
        bit = new int[l+1];
        
        for (int i = 0; i < l; i++) {
            update(i, nums[i]);
            arr[i] = nums[i];
        }
        
        // for (int a : arr)
        //     System.out.print(a + " ");
        
        // System.out.println("initialization completed");
        
    }
    
    public void update(int index, int val) {
        
        int diff = val - arr[index];
        // System.out.println("dif  = " + diff);
        arr[index] = val;
        index += 1;
        // System.out.println("index = " + index + " l = " + l);
        while (index <= l) {
            bit[index] += diff;
            // System.out.println("index = " + index + " bit[index] = " + bit[index]);
            index += index & (-index);
            
        }
        
    }
    
    public int sumRange(int left, int right) {
        
        int sum = 0;
        int index = right+1;
        
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        
        index = left;
        while (index > 0) {
            sum -= bit[index];
            index -= index & (-index);
        }
        
        return sum;
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

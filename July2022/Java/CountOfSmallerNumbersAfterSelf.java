
// @saorav21994
// TC : O(nlogn)
// SC : O(n)

// Using merge sort this time. Find BIT implementation in the last successful submission.
// Using merge sort in descending order, as we need smaller element(s) count to the right side.

class Solution {
    
    public List<Integer> countSmaller(int[] nums) {
        
        int l = nums.length;
        Pair [] arr = new Pair[l];
        Integer [] count = new Integer[l];
        Arrays.fill(count, 0);
        
        for (int i = 0; i < l; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        
        countSmallerUtil(arr, count, 0, l-1);
        
        
        return Arrays.asList(count);
        
    }
    
    
    public void countSmallerUtil(Pair [] arr, Integer [] count, int start, int end) {           // utility for merge sort
        
        if (start < end) {
            int mid = start + (end-start)/2;
            countSmallerUtil(arr, count, start, mid);
            countSmallerUtil(arr, count, mid+1, end);
            merge(arr, count, start, mid, end);
        }
        
    }
    
    
    // sorting in descending way, because we need count of SMALLER element to right    
    public void merge(Pair [] arr, Integer [] count, int start, int mid, int end) {
        
        Pair [] temp = new Pair[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;
        
        while (i <= mid && j <= end) {
            
            if (arr[i].value > arr[j].value) {      // we need to increment our count array
                count[arr[i].index] += end-j+1;       // all elements to right of j end will be smaller than i as we are sorting in descending order
                temp[k++] = arr[i++];
            }
            else {      // i < j -> nothing to be done here
                temp[k++] = arr[j++];
            }
            
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        
        for (int itr = start; itr <= end; itr++) {
            arr[itr] = temp[itr-start];
        }
        
    }
    
    
    
    class Pair {
        int value;
        int index;
        
        public Pair (int _value, int _index) {
            this.value = _value;
            this.index = _index;
        }
    }
    
}

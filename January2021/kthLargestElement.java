class Solution {
    //TC: O(nlogn) Sorting technique
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }



    // TC : nlogk  MIN heap technique
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int el: nums){
            pq.offer(el);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }


    // Worst case O(n2)
    // Best case O(n) => Quick Select techniquw
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length -1;
        int index = nums.length -k;
        while(start<= end){
            int partionIndex = parition(nums, start, end);
            if(partionIndex == index){
                return nums[index];
            } else if(partionIndex > index){
                end = partionIndex-1;
            } else if(partionIndex < index){
                start = partionIndex +1;
            }
        }
        return nums[start];

    }
    private int parition(int[] nums, int low, int high){
        int pivot = high;
        int i = low;
        int j = high;
        while(i<j){
            while(i<j && nums[i] <=nums[pivot]){
                i++;
            }

            while(i<j && nums[j] >=nums[pivot]){
                j--;
            }

            swap(nums, i,j);

        }

        swap(nums, i, pivot);
        return i;


    }

    private void swap(int[] nums, int i, int j){
        if(i!=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }




}
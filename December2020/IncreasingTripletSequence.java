class IncreasingTripletSequence {
    // TC O(n) , SC O(1)
    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;


        // left < mid < right
        for(int el : nums){
            if(el > mid) { // right element
                return true;
            } else if(el<mid && el>left){
                mid = el;
            } else if(el < left){
                left = el;
            }

        }
        return false;

    }
}
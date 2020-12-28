class ReachANumber {

    // TC O(1)
    public int reachNumber(int target) {
        if(target<0){
            target = -target;
        }

        int step =0;
        int totalSum = 0;
        while(target > totalSum){
            step++;
            totalSum += step;
        }

        if(target == totalSum){
            return step;
        } else {
            int difference = totalSum - target;
            if(difference % 2==0){
                return step;
            } else {
                // difference is odd
                if((step+1)%2==1){
                    return step +1;
                } else {
                    // step +1 is even
                    // step + 2 is odd
                    return step+2;
                }
            }
        }
    }
}
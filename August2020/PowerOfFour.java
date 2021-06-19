class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        int index = -1;
        if((num&(num-1))==0) {
            for(int i=0;i<32;i++){
                if((((num >>i) &1) == 1)){
                    if(i%2==0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
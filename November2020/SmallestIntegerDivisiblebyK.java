class SmallestIntegerDivisiblebyK {
    public int smallestRepunitDivByK(int K) {
        int remainder = 0;
        if(K ==2 || K==5 ){
            return -1;
        }

        for(int i=0;i<K;i++){
            remainder = (remainder*10 +1) %K;
            if(remainder == 0){
                return i+1;
            }
        }
        return -1;

    }
}
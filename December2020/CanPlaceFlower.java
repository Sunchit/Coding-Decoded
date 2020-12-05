class CanPlaceFlower {
    // TC : O(n)
    // SC : O(1)
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length;i++){
            int prev = 0;
            int next =0;
            if(i>0){
                prev = flowerbed[i-1];
            }


            if(i<flowerbed.length-1){
                next = flowerbed[i+1];
            }

            if(prev == 0 && next == 0 && flowerbed[i] ==0){
                n--;
                flowerbed[i] = 1;
            }
        }

        if(n<=0){
            return true;
        } else{
            return false;
        }
    }
}
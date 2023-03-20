// @saorav21994

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        for (int i = 0; i < l; i++) {
            if (n == 0)
                return true;
            boolean canPlace = true;
            if (flowerbed[i] == 0) {
                if (i > 0 && flowerbed[i-1] != 0)
                    canPlace = false;
                if (i < l-1 && flowerbed[i+1] != 0)
                    canPlace = false;
                if (canPlace) {
                    n -= 1;
                    flowerbed[i] = 1;
                }
            }

        }
        
        return (n == 0);
    }
}

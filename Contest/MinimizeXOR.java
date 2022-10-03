// https://leetcode.com/problems/minimize-xor/
// @author: anuj0503
class Solution {
    public int minimizeXor(int num1, int num2) {
        int count1 = getSetBits(num1);
        int count2 = getSetBits(num2);

        System.out.println(count1 + " " + count2);

        // If number ofr bits are same in both number than minimum XOR 0 can be attained.
        if(count1 == count2) return num1;

        // If num1 have greater bits then to minimze XOR we can maximum 
        // nullify count2 number of set bits from the MSB side
        if(count2 < count1){
            int diff = count1 - count2;
            int count = 0;
            int i = 0;

            while(count != diff){
                if((num1 & (1 << i)) > 0){
                    count++;
                    num1 ^= (1 << i);
                }
                i++;
            }

            return num1;
        } else {
            // If num2 have greater number of bits then we can nullify num1 set bits and
            // to maintain the count of num2 bits we have set bits from LSB side.
            int diff = count2 - count1;
            int i = 0;

            while(diff > 0){

                if((num1 & (1 << i)) == 0){
                    num1 ^= (1<<i);
                    diff--;
                }

                i++;
            }

            return num1;
        }

    }

    private int getSetBits(int n){
        int i = 0;
        int count = 0;
        while(n != 0){
            if((n & (1 << i)) > 0){
                count++;
                n = n^(1 << i);
            }

            i++;
        }

        return count;
    }
}

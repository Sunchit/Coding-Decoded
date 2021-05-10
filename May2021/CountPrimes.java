class Solution {

    // TC : O(nloglogn)
    // SC : O(n)
    public int countPrimes(int n) {
        boolean[] noList = new boolean[n];
        int count = 0;
        for(int i=2;i<n;i++){
            if(noList[i] == false){ // i no is prime
                count++;
                for(int j=2;j*i<n;j++){
                    noList[i*j] = true; // i*j is marked non prime
                }
            }
        }
        return count;
    }
}
// Solution 2 where inner loop is not starting from 2
class Solution {

    // TC : O(nloglogn)
    // SC : O(n)
    public int countPrimes(int n) {
        boolean[] noList = new boolean[n];
        int count = 0;
        for(int i=2;i<n;i++){
            if(noList[i] == false){ // i no is prime
                count++;
                for(int factor=i;factor<n;){

                    noList[factor] = true; // factor is marked non prime
                    factor = factor + i;
                }
            }
        }
        return count;
    }
}
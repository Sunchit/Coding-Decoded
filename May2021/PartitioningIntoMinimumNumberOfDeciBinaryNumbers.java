class Solution {

    // TC : O (len of n)
    // SC : O(1)
    public int minPartitions(String n) {
        int maxDigit = 0;
        for (char c : n.toCharArray()) {
            int digit =  c - '0';
            maxDigit = Math.max(maxDigit,digit);
        }
        return maxDigit;
    }
}
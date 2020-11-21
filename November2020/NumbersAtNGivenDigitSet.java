// Time complexity is O(nLen * dLen)
class   NumbersAtNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String nStr = n +"";
        int nLen = nStr.length();
        int noOfDigits = digits.length;

        int total = 0;
        // X, XX, XXX ...
        for(int i=1;i<nLen;i++){
            total += Math.pow(noOfDigits, i);
        }

        for(int i=0;i< nLen;i++){
            boolean hasSameNo = false;
            for(String digit : digits) {
                if(digit.charAt(0) < nStr.charAt(i)){
                    total += Math.pow(noOfDigits, nLen - i -1);
                } else if(digit.charAt(0) == nStr.charAt(i)){
                    hasSameNo = true;
                    if(i == nLen -1){
                        total++; // ["3", "4"] 4
                    }
                }
            }
            if(!hasSameNo){
                return total;
            }

        }

        return total;

    }
}
class Solution {

    public int superpalindromesInRange(String left, String right) {
        List<Long> palindromicNo = new ArrayList<>();

        Long leftNo = Long.parseLong(left);
        Long rightNo = Long.parseLong(right);

        int count = 0;

        for(long i= 1;i<10;i++){
            palindromicNo.add(i);
        }


        // [1, 10^18]
        // left Part is upto 10^4
        // right Part upto 10^4
        for(long i=1;i<10000;i++){
            String leftPart = Long.toString(i);
            String rightPart = new StringBuilder(leftPart).reverse().toString();

            palindromicNo.add(Long.parseLong(leftPart+rightPart)); // 10^8

            for(int digit=0;digit<10;digit++){
                palindromicNo.add(Long.parseLong(leftPart + digit + rightPart)); // 10^9
            }
        }


        for(long no : palindromicNo){
            long squareNo = no * no; // 10^18
            if(leftNo <= squareNo && rightNo >=squareNo &&  isPalindromic(Long.toString(squareNo))){

                count++;
            }
        }
        return count;
    }

    private boolean isPalindromic(String str){
        int start = 0;
        int end = str.length()-1;
        while(start< end){
            if(str.charAt(start)!= str.charAt(end)){
                return false;
            } else{
                start++;
                end--;
            }
        }

        return true;
    }
}
class Solution {
    // T C : O(len1) + O(len2)

    private class ComplexNo{
        private int rNo;
        private int iNo;

        public ComplexNo(int rNo, int iNo){
            this.rNo = rNo;
            this.iNo = iNo;
        }
    }
    public String complexNumberMultiply(String num1, String num2) {
        ComplexNo no1 = parseNo(num1);
        ComplexNo no2 = parseNo(num2);

        int rProductNo = (no1.rNo * no2.rNo) - (no1.iNo * no2.iNo);
        int iProductNo = (no1.iNo * no2.rNo) + (no1.rNo * no2.iNo) ;

        String ans = rProductNo + "+"+ iProductNo+ "i";
        return ans;

    }

    private ComplexNo parseNo(String no){
        int i=0;
        int rNo = 0;
        boolean isNegReal = false;
        if(no.charAt(i) == '-'){
            isNegReal = true;
            i++;
        }
        while(no.charAt(i) !='+'){
            rNo = 10*rNo + (no.charAt(i) - '0');
            i++;
        }
        if(isNegReal){
            rNo = -rNo;
        }
        i++; // +
        boolean isNegImg = false;
        if(no.charAt(i)=='-'){
            isNegImg = true;
            i++;
        }
        int iNo = 0;
        while(no.charAt(i)!='i'){
            // System.out.println(no.charAt(i));
            iNo = 10*iNo + (no.charAt(i) - '0');
            i++;
        }
        if(isNegImg){
            iNo = -iNo;
        }

        return new ComplexNo(rNo,iNo);
    }
}
// Total time complexity is O(n2)
// Space complexity is O(n)
class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i=0;i<len/2;i++){ // O(n)
            String subString = s.substring(0, i+1);  // O(n)
            if(len % subString.length() ==0){
                int noOfRepetitions = len / subString.length();
                StringBuilder tempStr = new StringBuilder();
                while(noOfRepetitions>0){
                    tempStr.append(subString); // O(n)
                    noOfRepetitions--;
                }
                if(tempStr.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}
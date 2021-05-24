class Solution {

    // TC : O(n)
    public String toLowerCase(String s) {
        char[] cList = s.toCharArray();
        for(int i=0;i<cList.length;i++) {

            // valid within range of upper case chars
            if(cList[i]>= 'A' && cList[i]<='Z')  {

                cList[i] = (char)( cList[i] +32); // lower case

            }
        }
        return new String(cList);
    }
}
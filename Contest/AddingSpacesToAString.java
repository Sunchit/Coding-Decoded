class Solution {
    // TC : O(len(s) + No of spaces that are to be inserted)
    // SC :  O(len(s) + No of spaces that are to be inserted)
    public String addSpaces(String s, int[] spaces) {
        char[] cStr = new char[s.length() + spaces.length];

        int i = 0; // iterator for spaces
        int j = 0; // iterator for s
        int k = 0; // iterator for building answer

        while(i<spaces.length && j<s.length()){
            int insertionIndex = spaces[i];
            // copy all characters till you do not reach space insertion index
            while(j<insertionIndex && j<s.length()){
                cStr[k] = s.charAt(j);
                k++;
                j++;
            }
            // insert space
            cStr[k] = ' ';
            k++;
            i++;
        }

        while(j<s.length()){
            cStr[k] = s.charAt(j);
            k++;
            j++;
        }


        return new String(cStr);
    }
}

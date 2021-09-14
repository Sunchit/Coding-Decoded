class Solution{
    // TC: O(n)
    // SC : O(1)
    public String reverseOnlyLetters(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = s.length()-1;

        while(start<end){
            if(!isEnglishCharacter(c[start])){
                start++;
                continue;
            }
            if(!isEnglishCharacter(c[end])){
                end--;
                continue;
            }

            // swap
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
        return new String(c);
    }

    private boolean isEnglishCharacter(char c){
        return Character.isUpperCase(c) || Character.isLowerCase(c);
    }
}
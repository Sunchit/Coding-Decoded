class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int shift = 0;
        char[] str = s.toCharArray();

        for( int i  = str.length-1; i >= 0; i-- ) {
            shift = (shift + shifts[i])%26;
            str[i] = (char)((str[i] - 'a' + shift) %26 + 'a');
        }

        return new String(str);
    }
}
class Solution {
    public boolean detectCapitalUse(String word) {
        // USA
        // Google
        // leetcode

        int length = word.length();
        if(length == 0|| length==1){
            return true;
        }

        char zeroChar = word.charAt(0);
        boolean zeroIsUpper = Character.isUpperCase(zeroChar);
        if(zeroIsUpper){
            char firstChar = word.charAt(1);
            boolean firstIsUpper = Character.isUpperCase(firstChar);
            for(int i=2;i<word.length();i++){
                char currentChar = word.charAt(i);
                boolean currentIsUpper = Character.isUpperCase(currentChar);
                if(currentIsUpper != firstIsUpper){
                    return false;
                }
            }
        } else {


            for(int i=1;i<word.length();i++){
                char currentChar = word.charAt(i);
                boolean currentIsUpper = Character.isUpperCase(currentChar);
                if(currentIsUpper != zeroIsUpper){
                    return false;
                }
            }
        }
        return true;
    }
}
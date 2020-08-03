class ValidPalindrome {

    // Need to conside only alpha numeric case => Only Letters and Digist
    // In case of character, we need to ignore case
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;

        // 2 pointer Approach

        while(start< end){
            char sChar = Character.toUpperCase(s.charAt(start));
            if(!Character.isLetterOrDigit(sChar)) {
                start++;
                continue;
            }


            char eChar = Character.toUpperCase(s.charAt(end));
            if(!Character.isLetterOrDigit(eChar)) {
                end--;
                continue;
            }

            // Upper cased start and end characters

            if(sChar!=eChar){
                return false;
            } else {
                start++;
                end--;
            }

        }
        return true;


    }
}
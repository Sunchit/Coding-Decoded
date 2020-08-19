class GoatLatin {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");

        StringBuilder newStr = new StringBuilder();

        String a = "a";
        for(String word : words) {
            String newWord ="";
            char startChar = word.charAt(0);
            if(isVowel(Character.toLowerCase(startChar))){
                newWord = word +"ma"  + a;
            } else{
                newWord = word.substring(1) + startChar + "ma" + a;
            }

            newStr.append(" "+newWord);

            a = a +"a";
        }


        return newStr.toString().substring(1);

    }

    private boolean isVowel(char c){
        return (c=='a'|| c=='e'|| c=='i'|| c=='o'||c=='u');
    }
}
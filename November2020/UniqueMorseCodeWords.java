class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> decodedStrings = new HashSet<>();
        String[] morseCode = new String[]{
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };

        for(String word: words){
            StringBuilder newStr = new StringBuilder();
            for(char c: word.toCharArray()){
                int index = c -'a';
                newStr.append(morseCode[index]);
            }
            decodedStrings.add(newStr.toString());

        }

        return decodedStrings.size();
    }
}
class Solution {

    // TC : O(no of queries +  no of el in wordList *2)

    // SC : O(n)
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> wordSet = new HashSet<>();
        for(String word: wordlist){

            wordSet.add(word);
        }

        Map<String, String> map = new HashMap<>();
        for(String word : wordlist){
            String lowerCaseStr = word.toLowerCase();
            map.putIfAbsent(lowerCaseStr, word);

            String vowelRemovedStr = getVowelRemovedStr(word);
            System.out.println(vowelRemovedStr + " " + word);
            map.putIfAbsent(vowelRemovedStr, word);

        }

        for(int i=0;i<queries.length;i++){
            if(wordSet.contains(queries[i])){
                continue;
            }

            String lowerCaseQuery = queries[i].toLowerCase();
            if(map.containsKey(lowerCaseQuery)){
                queries[i] = map.get(lowerCaseQuery);
                continue;
            }

            String vowelRemovedQuery = getVowelRemovedStr(queries[i]);

            if(map.containsKey(vowelRemovedQuery)){
                queries[i] = map.get(vowelRemovedQuery);
                continue;
            }

            queries[i] = "";


        }

        return queries;

    }

    private String getVowelRemovedStr(String word){
        char[] wordChar = word.toLowerCase().toCharArray();
        for(int i=0;i<word.length();i++){
            if(wordChar[i] == 'a' || wordChar[i] == 'e'||   wordChar[i] == 'i'||  wordChar[i] == 'o'||wordChar[i] == 'u'){
                wordChar[i] = '*';
            }

        }
        return new String(wordChar);
    }
}
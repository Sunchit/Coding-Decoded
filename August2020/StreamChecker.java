class StreamChecker {

    private class TrieNode{

        TrieNode[] children = null;
        boolean isLeaf = false;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    private TrieNode root = null;
    private StringBuilder queryStr = null;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        queryStr = new StringBuilder();
        for(String word: words){
            addWord(word);
        }
    }

    // Updating words in trie reversing the words in the trie
    private void addWord(String word){
        TrieNode it = root;
        for(int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            int index = c -'a';
            if(it!=null && it.children[index]==null){
                TrieNode newNode = new TrieNode();
                it.children[index] = newNode;
            }
            it = it.children[index];
        }

        it.isLeaf = true;
    }

    // Searching for the words in trie in the reverse order
    public boolean query(char letter) {
        queryStr.append(letter);
        return search(queryStr.toString());
    }

    private boolean search(String word){
        TrieNode it = root;
        for(int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            int index = c -'a';
            if(it!=null && it.children[index]!=null){
                it = it.children[index];
                if(it.isLeaf){
                    return true;
                }
            } else{
                return false;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
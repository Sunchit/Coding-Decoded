class Trie {

    private TrieNode root;
    private class TrieNode{
        private TrieNode[] children = null;
        private boolean isWord;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode it = root;
        for(char c :  word.toCharArray()) {
            int indexInTrieNode = c - 'a';
            if(it.children[indexInTrieNode] ==null){
                it.children[indexInTrieNode] = new TrieNode();
            }
            it = it.children[indexInTrieNode];
        }
        it.isWord = true;
    }



    public boolean search(String word) {
        TrieNode it = root;
        for(char c : word.toCharArray()){
            int indexInTrieNode = c - 'a';
            if(it.children[indexInTrieNode] == null){
                // no node was found
                return false;
            } else{
                it = it.children[indexInTrieNode];
            }
        }
        return it.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode it = root;
        for(char c : prefix.toCharArray()){
            int indexInTrieNode = c - 'a';
            if(it.children[indexInTrieNode] == null){
                return false;
            } else{
                it = it.children[indexInTrieNode];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
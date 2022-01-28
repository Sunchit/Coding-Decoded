class AddAndSearchWord {

    private class TrieNode {
        private TrieNode[] children = null;
        boolean isLeaf;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        TrieNode it = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c -'a';
            if(it.children[index]==null){
                TrieNode newNode = new TrieNode();
                it.children[index] = newNode;
            }
            it = it.children[index];
        }
        it.isLeaf = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int sIndex, TrieNode root){
        if(word.length()==sIndex){
            return root.isLeaf;
        }

        char c = word.charAt(sIndex);
        if(c=='.'){
            for(int i=0;i<26;i++){
                if(root.children[i]!=null && searchHelper(word, sIndex+1, root.children[i])){
                    return true;
                }
            }

        } else {
            int index = c -'a';
            if(root.children[index]!=null && searchHelper(word, sIndex+1, root.children[index])){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
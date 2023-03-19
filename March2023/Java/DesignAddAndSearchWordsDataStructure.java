// @saorav21994

class WordDictionary {
    
    private class TrieNode {
        private TrieNode [] trie;
        boolean isLeaf;
         
        public TrieNode() {
            trie = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        
        if (word == null || word.length() == 0)
            return;
        
        TrieNode node = root;
        
        for (char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if (node.trie[idx] == null) {
                TrieNode newNode = new TrieNode();
                node.trie[idx] = newNode;
            }
            node = node.trie[idx];
        }
        
        node.isLeaf = true;
        
    }
    
    public boolean search(String word) {
        return isWord(word, 0, root);
    }
    
    public boolean isWord(String word, int idx, TrieNode node) {
        if (idx == word.length()) {
            return node.isLeaf;
        }
        
        char ch = word.charAt(idx);
        
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.trie[i] != null && isWord(word, idx+1, node.trie[i])) {
                    return true;
                }
            }
        }
        else {
            int i = ch - 'a';
            if (node.trie[i] != null && isWord(word, idx+1, node.trie[i])) {
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

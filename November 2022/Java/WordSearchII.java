// @saorav21994

class Solution {
    
    class TrieNode {
        
        TrieNode [] trie;
        int R = 26;
        String leaf;
        
        TrieNode() {
            trie = new TrieNode[R];
        }
        
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode trie = createTrie(words);
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie, res, m, n);
            }
        }
        
        return res;
    }
    
    public TrieNode createTrie(String [] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            char [] wArray = word.toCharArray();
            for (char ch : wArray) {
                if (node.trie[ch-'a'] == null)
                    node.trie[ch-'a'] = new TrieNode();
                node = node.trie[ch-'a'];
            }
            node.leaf = word;
        }
        return root;
    }
    
    public void dfs(char [][] board, int i, int j, TrieNode node, List<String> res, int m, int n) {
        char ch = board[i][j]; 
        if (board[i][j] == '#' || node.trie[ch-'a'] == null)
            return;
        node = node.trie[ch-'a'];
        if (node.leaf != null) {
            res.add(node.leaf); 
            node.leaf = null;   // remove duplicates
        }
        board[i][j] = '#';  // visited
        if (i > 0)
            dfs(board, i-1, j, node, res, m, n);
        if (j > 0)
            dfs(board, i, j-1, node, res, m, n);
        if (i < m-1)
            dfs(board, i+1, j, node, res, m, n);
        if (j < n-1)
            dfs(board, i, j+1, node, res, m, n);
        board[i][j] = ch;
    }
    
} 

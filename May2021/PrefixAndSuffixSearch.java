// Solution-I
class WordFilter {
    HashMap<String, Integer> map = null;
    // O(N*l*l)
    public WordFilter(String[] words) {

        map = new HashMap<>();

        int index=0;
        for(String word: words){
            for(int i=0;i<=word.length();i++){
                for(int j=0;j<=word.length();j++){
                    String prefixAndSuffix = word.substring(0, i) + "#" + word.substring(j);

                    map.put(prefixAndSuffix, index);


                }
            }
            index++;
        }
    }

    // O(1)
    public int f(String prefix, String suffix) {
        String queryStr = prefix + "#" + suffix;
        return map.getOrDefault(queryStr, -1);
    }
}

//Solution -II
class WordFilter {

    class TrieNode {
        TrieNode[] children;
        int index;

        public TrieNode() {
            children = new TrieNode[27];
        }

        public void insert(String s, int index) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                int n = c - 'a';
                if (cur.children[n] == null) {
                    cur.children[n] = new TrieNode();
                }
                cur = cur.children[n];
                cur.index = index;
            }
        }

        public int startsWith(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                TrieNode next = cur.children[c - 'a'];
                if (next == null) {
                    return -1;
                }
                cur = next;
            }
            return cur.index;
        }
    }

    TrieNode root;

    // apple -> {apple, e{apple, le{apple, ple{apple, pple{apple, apple{apple;
    public WordFilter(String[] words) {
        root = new TrieNode();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String s = words[i];
            for (int j = 0; j <= s.length(); j++) {
                root.insert(s.substring(j, s.length()) + '{' + s, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return root.startsWith(suffix + '{' + prefix);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
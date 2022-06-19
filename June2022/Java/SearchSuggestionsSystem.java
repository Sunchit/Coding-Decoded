
// @saorav21994
// TC : O(m*n) for Trie insertion and O(searchWord length) for query as dfs for n time is constant -> 26*n
// SC : O(26*no. of words)
// Contains little optimisation
// In real life scenarios this is the most optimised approach as in real life the avg. length of word is <<< no. of words in search space. 2-pointyer approach during query will take O(n) for each word which will be way worse than trie.


// Submission Id - https://leetcode.com/submissions/detail/725810141/

class Solution {
    
    class Trie {
        
        Trie [] children;
        boolean isEnd;              // default -> false
        
        Trie() {
            children = new Trie[26];
        }
        
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        // Using Trie and then find 3 match for each prefix
        
        Trie root = new Trie();
        
        // insert the strings in products to trie
        for (int i = 0; i < products.length; i++) {
            
            Trie cur = root;
            String word = products[i];
            
            for (char ch : word.toCharArray()) {
                
                // create a node if not present
                if (cur.children[ch-'a'] == null) {
                    cur.children[ch-'a'] = new Trie();    
                }
                cur = cur.children[ch-'a'];
            }
            
            cur.isEnd = true;           // word completed
            
        }
        
        List<List<String>> res = new ArrayList<>();
        
        String cursw = "";      // current search word
        boolean proceed = true;
        for (char ch : searchWord.toCharArray()) {
            
            cursw += ch;
            List<String> tmp = new ArrayList<>();
            
            // little optimisation
            
            if (!proceed) {     // we have already run out of match, no need to go further prefix match
                res.add(new ArrayList<>(tmp));
                continue;
            }
            
            proceed = findPrefixMatch(cursw, tmp, root);
            res.add(new ArrayList<>(tmp));
                
        }
        
        return res;
        
    }
    
    
    public static boolean findPrefixMatch(String prefix, List<String> cur, Trie root) {
        
        Trie trieNode = root;
        
        // reach to end of current incoming prefix
        for (char ch : prefix.toCharArray()) {
            if (trieNode.children[ch-'a'] == null) 
                return false;             // no prefix match possible
            trieNode = trieNode.children[ch-'a'];
        }
        
        fetchTopNUsingDfs(trieNode, 3 /*number of matches to fetch = n */, cur, prefix);
        return true;
        
    }
    
    
    public static void fetchTopNUsingDfs(Trie trieNode, int n, List<String> cur, String word) {
        
        if (cur.size() == n)
            return;
        
        if (trieNode.isEnd) {       // current node is a complete word
            cur.add(word);
        }
        
        // iterate through all 26 character for current node
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (trieNode.children[ch-'a'] != null) {
                fetchTopNUsingDfs(trieNode.children[ch-'a'], n, cur, word+ch);
            }
        }
        
    }
    
}




// @saorav21995
// Two-pointer approach with sorting
// TC : O(m*n*log n)
// SC : O(max. of m)
// Sorting in java will take O(m) for each comparison among 2 string with avg. length m in worst case. Also for real life scenario, this approach is infeasible as stated in the first approach.

// Submission Id - https://leetcode.com/submissions/detail/500969600/

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> tmp = new ArrayList<String>();
            res.add(tmp);
        }
        int l = products.length;
        int s = 0, e = l-1;
        for (int i = 0; i < searchWord.length() && s <= e; i++) {
            while (s <= e && (products[s].length() <= i || searchWord.charAt(i) != products[s].charAt(i))) {
                s += 1;
                // System.out.println("s = " + s);
            }
            // System.out.println("itr complete");
            while (s <= e && (products[e].length() <= i || searchWord.charAt(i) != products[e].charAt(i))) {
                e -= 1;
                // System.out.println("e = " + e);
            }
            for (int j = s; j <= e && j < s+3; j++) {
                res.get(i).add(products[j]);
            }
        }
        return res;
    }
}

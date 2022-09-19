// https://leetcode.com/problems/sum-of-prefix-scores-of-strings/
// @author: anuj0503
class Solution {
    class TrieNode{
        TrieNode[] children;
        int[] count;
        TrieNode(){
            children = new TrieNode[26];
            count = new int[26];
        }
    };

    TrieNode root;
    public int[] sumPrefixScores(String[] words) {
        root = new TrieNode();
        int n = words.length;
        int[] result = new int[n];

        for(String s : words){
            buildTrie(root, s);
        }

        for(int i = 0; i < n; i++){
            String s = words[i];

            result[i] = getPrefixCount(root, s);
        }
        return result;
    }

    private void buildTrie(TrieNode root, String s){
        TrieNode currNode = root, prevNode = null;
        for(int i = 0; i < s.length(); i++){

            if(currNode.children[s.charAt(i) - 'a'] == null){
                currNode.children[s.charAt(i) - 'a'] = new TrieNode();
            }
            currNode.count[s.charAt(i) - 'a'] = currNode.count[s.charAt(i) - 'a'] + 1;
            currNode = currNode.children[s.charAt(i) - 'a'];
        }
    }

    private int getPrefixCount(TrieNode root, String s){
        int sum = 0;
        TrieNode curr = root;
        for (char ch: s.toCharArray()) {
            int index = ch - 'a';

            sum += curr.count[index];

            curr = curr.children[index];
        }

        return sum;
    }
}

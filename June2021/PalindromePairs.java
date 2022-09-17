class Solution {

    // TC:O(n*k2)
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList();
        Map<String, Integer> map = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            map.put(words[i], i);
        }

        // Empty String case
        if (map.containsKey("")) {
            int blankIdx = map.get("");
            for (int i = 0; i < words.length; ++i) {
                if (i != blankIdx && isPalindrome(words[i])) {
                    res.add(Arrays.asList(blankIdx, i));
                    res.add(Arrays.asList(i, blankIdx));
                }
            }
        }

        // Reflection case
        for (int i = 0; i < words.length; ++i) {
            String reversed = new StringBuilder(words[i]).reverse().toString();
            Integer reversedIdx = map.get(reversed);
            if (reversedIdx != null && reversedIdx != i) {
                res.add(Arrays.asList(i, reversedIdx));
            }
        }


        // Tricky case
        for (int i = 0; i < words.length; ++i) {
            String cur = words[i];
            for (int cut = 1; cut < cur.length(); ++cut) {
                String left = cur.substring(0, cut);
                String right = cur.substring(cut);
                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reversedRight)) {
                        res.add(Arrays.asList(map.get(reversedRight), i));
                    }
                }
                if (isPalindrome(right)) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reversedLeft)) {
                        res.add(Arrays.asList(i, map.get(reversedLeft)));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        while(i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
}




//correction to original solution



class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Map<String,Integer> map = new HashMap<>();
    public List<List<Integer>> palindromePairs(String[] words) {
        if(words == null || words.length == 0){
            return result;
        }
        
        String[]reverse = new String[words.length];
    
        
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
            reverse[i] = new StringBuilder(words[i]).reverse().toString();
         }
        
        
        
        if(map.containsKey("")){
            for(int i=0;i<words.length;i++){
                if(i != map.get("") && isPalindrome(words[i],0,words[i].length()-1)){
                    result.add(Arrays.asList(map.get(""),i));
                    result.add(Arrays.asList(i,map.get("")));
                }
            }
        }
        
        //reflection
        
        for(int i=0;i<words.length;i++){
          
            if(map.containsKey(reverse[i])){
                Integer idx = map.get(reverse[i]);
                if(idx != null && idx != i){
                result.add(Arrays.asList(i,idx));
                }
            }
        }
        
        for(int i=0;i<words.length;i++){
            String currentWord = words[i];
            for(int cut=1;cut<currentWord.length();cut++){
                String leftCut = currentWord.substring(0,cut);
                String rightCut = currentWord.substring(cut);
                if(isPalindrome(leftCut,0,leftCut.length()-1)){
                    String r = new StringBuilder(rightCut).reverse().toString();
                    if(map.containsKey(r)){
                        result.add(Arrays.asList(map.get(r),i));
                    }
                }
                if(isPalindrome(rightCut,0,rightCut.length()-1)){
                     String r = new StringBuilder(leftCut).reverse().toString();
                    if(map.containsKey(r)){
                        result.add(Arrays.asList(i,map.get(r)));
                    }
                }
            }
        }
        
        return result;
        
    }
    
    
    public boolean isPalindrome(String word,int start,int end){
        while(start < end){
            if(word.charAt(start++) != word.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}


//Trie based solution which works for timeouts too

 class TrieNode{
    TrieNode []children;
    int id;
    List<Integer>pos;
    TrieNode(){
        children=new TrieNode[26];
        pos=new ArrayList<>();
        id=-1;
    }
}
class Solution {
    TrieNode root;
    List<List<Integer>>result;
    Solution(){
        root=new TrieNode();
        result=new ArrayList<>();
    }
    public boolean isPalindrome(String word,int start,int end){
        while(start<end){
            if(word.charAt(start++)!=word.charAt(end--)){
                return false;
            }
            
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        
        for(int i=0;i<words.length;i++){
            insertIntoTrie(words[i],i);
        }
         for(int i=0;i<words.length;i++){
            searchInTrie(words[i],i);
        }
        return result;
    }
    
    public void insertIntoTrie(String word,int id){
        TrieNode pCrawl=root;
        for(int i=word.length()-1;i>=0;i--){
            int index=word.charAt(i)-'a';
            
            if(pCrawl.children[index]==null){
                pCrawl.children[index]=new TrieNode();
            }
            if(isPalindrome(word,0,i)){
             pCrawl.pos.add(id);
                
            }
             pCrawl=pCrawl.children[index];
            
        }
        pCrawl.id=id;
        pCrawl.pos.add(id);
    }
    public void searchInTrie(String word,int id){
        TrieNode pCrawl=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(pCrawl.id>=0&&pCrawl.id!=id&&isPalindrome(word,i,word.length()-1)){
                List<Integer>res=new ArrayList<>();
                res.add(id);
                res.add(pCrawl.id);
                result.add(res);
            }
            if(pCrawl.children[index]==null)
                return;
                pCrawl=pCrawl.children[index];
        }
        for(int i:pCrawl.pos){
            if(i==id)
                continue;
            List<Integer>res=new ArrayList<>();
            res.add(id);
            res.add(i);
            result.add(res);
        }
    }
}
class MapSum {

     Map<String, Integer> map = null;
     /** Initialize your data structure here. */
     public MapSum() {
         map = new HashMap<>();
     }

     public void insert(String key, int val) {
         map.put(key, val);
     }

     public int sum(String prefix) {
         int total = 0;
         for(Map.Entry<String, Integer> entry : map.entrySet()){
             if(entry.getKey().startsWith(prefix)){
                 total += entry.getValue();
             }
         }
         return total;
     }
 }


class MapSum {

  private class TrieNode{
    TrieNode[] children=new TrieNode[26];
    int weight=0;
  }

  TrieNode root = null;
  public MapSum() {
    root=new TrieNode();
  }

  public void insert(String key, int val) {
    TrieNode curr=root;
    for (char c:key.toCharArray()){
      if(curr.children[c-'a']==null){
        curr.children[c-'a']=new TrieNode();
      }
      curr=curr.children[c-'a'];
    }
    curr.weight=val;
  }

  public int sum(String prefix) {
    TrieNode curr=root;
    for (char c:prefix.toCharArray()){
      if(curr.children[c-'a']==null) return 0;
      curr=curr.children[c-'a'];
    }
    return dfs(curr);
  }
  private int dfs(TrieNode node){
    int sum=0;
    for (int i=0;i<26;i++){
      if(node.children[i]!=null){
        sum+=dfs(node.children[i]);
      }
    }
    return sum+node.weight;
  }
}
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
class StreamChecker {
	private class TrieNode{
		private TrieNode[] children =null;
		private boolean isLeaf;
		public TrieNode(){
			children = new TrieNode[26];
		}
	}

	private TrieNode root = null;

	private StringBuilder queryStr = null;

	public StreamChecker(String[] words) {
		root = new TrieNode();
		queryStr = new StringBuilder();
		for(String word : words) {
			addWord(word);
		}
	}


	private void addWord(String word){
		TrieNode it = root;
		for(int i=word.length()-1;i>=0;i--){ // Iterating in revese order
			char c = word.charAt(i);
			int index = c - 'a';
			if(it!=null && it.children[index]==null){
				TrieNode newNode = new TrieNode();
				it.children[index] = newNode;
			}
			it = it.children[index];
		}
		it.isLeaf = true;
	}

	public boolean query(char letter) {
		queryStr.append(letter);
		return search(queryStr.toString());
	}

	private boolean search(String queryStr){
		TrieNode it = root;
		for(int i=queryStr.length()-1;i>=0;i--){
			char c = queryStr.charAt(i);
			int index = c - 'a';

			if(it!=null && it.children[index]!=null){
				it = it.children[index];
				if(it.isLeaf){
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}

}

class Trie {
public:
    unordered_map<string, int> m,m1;
    
    Trie() {
        
    }
    
    void insert(string word) {
        m[word]++;
        string x;
        for(int i=0;i<word.size();i++)
        {
            x.push_back(word[i]);
            if(m1[x]==0) m1[x]++;
        }
    }
    
    bool search(string word) {
        return m[word];
    }
    
    bool startsWith(string prefix) {
        
        return m1[prefix];
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */

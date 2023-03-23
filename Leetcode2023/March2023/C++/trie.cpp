class Trie {
    unordered_map<char,Trie*> dict;
    bool eos=false;
public:
    Trie* root=NULL;
    Trie() {
        // root= new Trie();
        // eos=false;
        root=this;
    }
    
    void insert(string word) {
        // if(!root) root=new Trie();
        Trie* node= root;
        for(auto& i:word)
        {
            // cout<<i<<endl;
            if(node->dict.find(i)==node->dict.end())
            {
                node->dict[i]=new Trie();
                // node->eos=false;
            }
            node =node->dict[i];
        }        
        node -> eos=true;
    }
    
    bool search(string word) {
        // if(!root) root=new Trie();
        Trie* node = root;
        for(auto& i:word)
        {
            if(node->dict.find(i)==node->dict.end()) return false;
            node = node->dict[i];
        }
        return node->eos;
    }
    
    bool startsWith(string prefix) {
        Trie* node = root;

        for(auto& i:prefix)
        {
            if(node->dict.find(i)==node->dict.end()) return false;
            node = node->dict[i];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
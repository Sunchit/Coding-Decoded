class Trie{
   
    public :
        Trie()
        {
            for(auto& i:children)
                i=NULL;
            end=false;
        }
        Trie* children[26];
        bool end;
    
};
class StreamChecker {
    Trie* trie;
    deque<char> q;
    
public:
    StreamChecker(vector<string>& words) {
        trie=new Trie();
        for(auto& i:words)
        {
            reverse(begin(i),end(i));
            insert(i,trie);
        }
        
    }
    

    
    bool query(char letter) {
        q.push_front(letter);
    
        Trie* curr=trie;
        for(int i=0;i<q.size();i++)
        {
            int idx=q[i]-'a';
            curr=curr->children[idx];
            if(!curr) return false;
            if(curr->end)
                return true;
            
        }
        return curr->end;
    }
    
    void insert(string word,Trie* root)
    {
        Trie* node=root;
        for(int i=0;i<word.size();i++)
        {
            int idx=word[i]-'a';
            if(node->children[idx]==NULL)
                node->children[idx]=new Trie();
            node=node->children[idx];
        }
        
        node->end=true;
    }
};

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker* obj = new StreamChecker(words);
 * bool param_1 = obj->query(letter);
 */
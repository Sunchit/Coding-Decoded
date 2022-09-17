class WordDictionary {
public:
    vector<WordDictionary*> child;
    bool end;
    WordDictionary() {
        this->child.resize(26,NULL);
        this->end=false;
    }
    
    void addWord(string word) {
        WordDictionary* curr=this;
        for(auto& i:word)
        {
            if(!curr->child[i-'a']) curr->child[i-'a']=new WordDictionary();
            curr=curr->child[i-'a'];
        }
        curr->end=true;
    }
    bool dfs(int i,string& word,WordDictionary* root)
    {
        if(i==word.length()) root->end;
        
        WordDictionary* curr=root;
        for(int j=i;j<word.size();j++)
        {
            
            if(word[j]=='.')
            {
                vector<WordDictionary*>& allchilds=curr->child;
                for(int k=0;k<allchilds.size();k++)
                    if(allchilds[k]!=NULL && dfs(j+1,word,allchilds[k])) return true;
                return false;
                       
            }
            
            
            if(!curr->child[word[j]-'a']) return false;
             
             curr=curr->child[word[j]-'a'];
        }
        
        return curr->end;
        
        
    }
    bool search(string word) {
        WordDictionary* curr=this;
        for(int i=0;i<word.length();i++)
        {
            
            if(word[i]=='.')return dfs(i,word,curr);
                       
            if(!curr->child[word[i]-'a']) return false;
             
             curr=curr->child[word[i]-'a'];
        }
        return curr->end;
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */
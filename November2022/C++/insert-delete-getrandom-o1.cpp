class RandomizedSet {
private:
    vector<int>num;
    map<int,int>index;
public:
    RandomizedSet() {
        
    }
    
    bool insert(int val) {
        if(index.find(val)!=index.end()){
         
            return false;
        }
        
           index[val] = num.size();
            num.push_back(val);
        
        return true;
    }
    
    bool remove(int val) {
         if(index.find(val)==index.end()){
         
            return false;
        }
        
          int ind =  index[val];
           num[ind] = num[num.size()-1];
        index[num[num.size()-1]] = ind;
        num.pop_back();
        index.erase(val);
        return true;
    }
    
    int getRandom() {
        int ind = rand()%num.size();
        
        return num[ind];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */
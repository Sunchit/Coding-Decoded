class BrowserHistory {
public:
    vector<string> v;
    int ind = 0;
    BrowserHistory(string homepage) {
        
        v.push_back(homepage);
    }
    
    void visit(string url) {
        
        ind++;
        v.resize(ind);//Visits url from the current page. It clears up all the forward history.
        v.push_back(url);
    }
    
    string back(int steps) {
        
        int n = v.size();
        ind = max(0, ind-steps);
        return v[ind];           
    }
    
    string forward(int steps) {
       ind = min((int)v.size()-1, ind+steps);
        return v[ind];
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */

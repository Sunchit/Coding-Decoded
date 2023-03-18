class BrowserHistory {
    vector<string> history;
    int idx;
    // int eos;
public:
    BrowserHistory(string homepage) {
        history.push_back(homepage);
        idx=0;
        // eos=0;
    }
    
    void visit(string url) {
        if(idx+1!=history.size())
        {
            history.erase(history.begin()+idx+1,history.end());
        }
        history.push_back(url);
        idx++;
    }
    
    string back(int steps) {
        idx =max((int)(idx-steps),0);
        // if(idx-steps>=0)
        // {
        //     idx-=steps;
        //     return history[idx];
        // }
        // return "";
        return history[idx];
    }
    
    string forward(int steps) {
        idx=min((int)(idx+steps),(int)(history.size()-1));
        return history[idx];
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */
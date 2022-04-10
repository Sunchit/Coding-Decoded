class FreqStack {
public:
    unordered_map<int,int> dict;
    int max_val=-1;
    stack<int> main_stack;
    stack<int> temp_stack;
    unordered_map<int,int> cdict;
    FreqStack() {
       
    }
    
    void push(int val) {
        dict[val]++;
        int count=dict[val];
        if(count-1!=0)  cdict[count-1]--;
        cdict[count]++;
        max_val=max(max_val,count);
        main_stack.push(val);
        // cout<<max_val;
    }
    
    int pop() {
        int popped=-1;
        while(main_stack.size() && dict[main_stack.top()]!=max_val)
        {
            temp_stack.push(main_stack.top());
            main_stack.pop();
        }
        if(main_stack.size())
       {
            popped=main_stack.top();
            main_stack.pop();
            dict[popped]--;
            cdict[max_val]--;
            cdict[max_val-1]++;
            if(cdict[max_val]<=0) max_val--; 
        }
        while(temp_stack.size())
        {
            main_stack.push(temp_stack.top());
            temp_stack.pop();
        }
        
        return popped;
    }
};

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack* obj = new FreqStack();
 * obj->push(val);
 * int param_2 = obj->pop();
 */
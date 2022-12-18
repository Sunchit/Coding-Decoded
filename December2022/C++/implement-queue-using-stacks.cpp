class MyQueue {
    
    stack<int>input;
    stack<int>output;
    
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        
     input.push(x);
        
        
    }
    
    int pop() {
        
       if(output.size()){
           
           int val = output.top();
               output.pop();
           return val;
       }
        else{
            
            
            while(input.empty() == false){
                
                output.push(input.top());
                input.pop();
            }
            
           int val = output.top();
               output.pop();
           return val;
        }
    }
    
    int peek() {
        
    if(output.size()){
           
                   int val = output.top();

                   return val;
            }
        else{
            
            while(input.empty() == false){
                
                output.push(input.top());
                input.pop();
            }
            
           int val = output.top();
            
           return val;
        }
    }
    
    bool empty() {
        
        return (input.size() == 0) && (output.size() == 0);
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
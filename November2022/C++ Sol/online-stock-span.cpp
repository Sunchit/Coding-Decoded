// @Sarang661
class StockSpanner {
private:
    stack<pair<int,int>>prev;

public:
    StockSpanner() {
    }
    
    int next(int price) {
        int num = 1;
        while(prev.size()>0 && prev.top().first<=price){
           num = num + prev.top().second;
            prev.pop();
        }
        prev.push({price,num});
        
        return num;
    }

           
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */
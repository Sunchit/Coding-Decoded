// @Sarang661
class MedianFinder {
private:
    priority_queue<int>q1;
    priority_queue<int,vector<int>,greater<int>>q2;
public:
    MedianFinder() {
        
    }
    
    void addNum(int num) {
      if(q1.size()>0 && q1.top()<=num){
          q2.push(num);
      }
        else if(q2.size()>0 && q2.top()>num){
            q1.push(num);
        }
        else{
            q1.push(num);
        }
    }
    
    double findMedian() {
        while(q1.size()>q2.size()){
            q2.push(q1.top());
            q1.pop();
        }
           while(q2.size()>q1.size()){
            q1.push(q2.top());
            q2.pop();
        }
        double ans = 0.0;
        int size = q1.size()+q2.size();
        if(size%2==0){
            ans = (double)(q1.top()+q2.top())/2.0;
           
            return ans;
        }
        else{
            if(q1.size()>q2.size()){
                return q1.top();
            }
            else{
                return q2.top();
            }
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
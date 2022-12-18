#define ll long long int
class Solution {
public:
   int evalRPN(vector<string>& tokens) {
    
       stack<ll>st;
       
       ll len = tokens.size();
       
       for(auto num:tokens){
           
           if(num.size()>1 || isdigit(num[0])){
               
               st.push(stoll(num));
           }
           else{
               
               auto x2 = st.top(); st.pop();
               auto x1 = st.top(); st.pop();
               
               switch(num[0]) {
                case '+': x1+=x2; break;
                case '-': x1-=x2; break;
                case '*': x1*=x2; break;
                case '/': x1/=x2; break;
            }
            st.push(x1);
               
           }
       }
       
       return st.top();
}
};
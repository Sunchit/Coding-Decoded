// @Sarang661
class Solution {
public:
    int maximum69Number (int num) {
       string curr = to_string(num);

       for(int index = 0; index < curr.size(); index++){
           if(curr[index] == '6'){
               curr[index] = '9';
               break;
           }
       }

       return stoi(curr);
    }
};
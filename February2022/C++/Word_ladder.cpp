class Solution {
public:
    int ladderLength(string bg, string ew, vector<string>& wlist) {
      //bg = beginWord, ew = endWord :P
        unordered_set<string>st;
        bool present = false;
        for(auto p : wlist){
           if(ew.compare(p) == 0)
                present = true;
            st.insert(p);
        }
      //if end_word is not present
        if(present == false)
            return 0;
        int depth = 0;
        queue<string>q;
        //we will go in a breadth first manner because we want the shortest path among all the path
        q.push(bg);
        while(!q.empty()){
            depth+=1;
            int size = q.size();
            while(size--){
                string curr = q.front();
                q.pop();
                
                for(int i=0;i<curr.size();i++){
                    
                    string temp = curr;
                    //check all the possibilites
                    for(char c ='a';c<='z';c++){
                        temp[i] = c;
                        if(curr.compare(temp) == 0)
                            continue;
                      //if i got the exact word from queue which i wanted
                        if(temp.compare(ew)==0)
                            return depth+1;
                        if(st.find(temp) != st.end()){
                            q.push(temp);
                            st.erase(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }
};

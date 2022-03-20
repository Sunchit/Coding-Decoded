class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        int m=pushed.size(),stackidx=0,ps=1,pps=0,empty_val=0;
        while(ps<m || pps<m)
        {
            while(ps<m)
            {
                if(stackidx<0)
                {
                    stackidx++;
                    while(stackidx<m && pushed[stackidx]==-1) stackidx++;
                    if(stackidx!=m) ps++;
                }
                
                if(stackidx>=0 && stackidx<m && pushed[stackidx]==popped[pps]) break;
                while(stackidx!=m && pushed[stackidx+1]==-1)stackidx++;
                if(stackidx!=m) stackidx++;
                ps++;
            
            }
        
            
            while(pps<m && stackidx>=0 && stackidx<m &&  pushed[stackidx]==popped[pps])
            {
                pushed[stackidx]=-1;
                stackidx--;
                while(stackidx>=0 && pushed[stackidx]==-1) stackidx--;
                pps++;
            }
            if(ps>=m) return pps==m;
        }
        
        
        return pps==m;
        
    }
};
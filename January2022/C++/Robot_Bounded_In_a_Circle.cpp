class Solution {
public:
    bool isRobotBounded(string in) {
        int x=0,y=0;
        int dir=0;
        for(auto& i:in)
        {
            if(i=='G'){
                int d=dir%4;
                if(d==0) y++;
                if(d==-1 || d==3) x--;
                if(d==1 ||  d==-3) x++;
                if(abs(d)==2) y--;
            }
            else
            {
                if(i=='L') dir--;
                else dir++;
            }
        }
           
        return (x==0 && y==0) || dir%4 !=0 ? true:false ;
    }
};
// @Sarang661
class Solution {
private:
 void unions(int a,int b,vector<int>&par){
       int par1 = findPar(a,par);
       int par2 = findPar(b,par);
       par[par1] = par2;
   }
    int findPar(int node, vector<int>&par){
        if(par[node]==node){
            return node;
        }
        return par[node]= findPar(par[node],par);
    }
public:
    int removeStones(vector<vector<int>>& stones) {
        int n = stones.size();
        vector<int>par(n);
        for(int i=0;i<n;i++){
            par[i] = i;
        }
        set<int>st;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((stones[i][0]== stones[j][0]) || (stones[i][1]==stones[j][1])){
                    unions(i,j,par);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            st.insert(findPar(i,par));
        }
        
        return n-st.size();
    }
};
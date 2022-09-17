class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        
        int pre[m+1][n];
        for(int i=0;i<=m;i++){
            for(int j=0;j<n;j++){
                pre[i][j]=0;
            }
        }
        
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
            
                pre[i+1][j]=pre[i][j]+matrix[i][j];
            }
        }
        
        unordered_map<int,int> mp;
        int cnt=0;
        
        for(int row =0 ; row<m; row++){
            
            for(int i=row; i<m;i++){
                mp.clear();
                int sum=0;
                for(int j=0; j<n;j++){
                     sum+= pre[i+1][j]-pre[row][j];
                    if(sum==target)
                        cnt++;
                    if(mp.find(sum-target)!=mp.end()){
                        cnt+=mp[sum-target];
                    }
                    mp[sum]++;
                }
            }
        }
        
        return cnt;
    }
};

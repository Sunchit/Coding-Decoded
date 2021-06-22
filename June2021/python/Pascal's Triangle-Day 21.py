class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows==1:
            return [[1]]    
        new_lis=[[1]]
        lis=[]
        for j in range(2,numRows+1):
            lis=[0 for _ in range(j)]
            lis[0],lis[-1]=1,1
            for i in range(1,len(lis)-1):
                # if i>0 and i <len(lis)-1:
                lis[i]=new_lis[-1][i-1]+new_lis[-1][i]
            
            new_lis+=[lis]
            
        return new_lis

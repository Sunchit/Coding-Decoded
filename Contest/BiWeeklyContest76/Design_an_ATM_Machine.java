// Author: Shobhit Behl (LC: shobhitbruh)
class ATM {
    long[][] arr;
    public ATM() {
        arr=new long[2][5];
        arr[1][0]=20;
        arr[1][1]=50;
        arr[1][2]=100;
        arr[1][3]=200;
        arr[1][4]=500;
    }
    
    public void deposit(int[] b) {
        for(int i=0;i<b.length;i++){
            arr[0][i]+=b[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] ret=new int[5];
        long w=amount;
        long[] f=new long[5];
        for(int i=0;i<f.length;i++){
            f[i]=arr[0][i];
        }
        
        for(int i=arr[0].length-1;i>=0;i--){
            if((w/arr[1][i])>0&&arr[0][i]>0){
                long r=(w/arr[1][i]);
                if((w/arr[1][i])>arr[0][i]){
                    r=arr[0][i];
                }
                ret[i]=(int)r;
                arr[0][i]-=r;
                w-=arr[1][i]*r;
            }
        }
        if(w!=0){
            arr[0]=f;
            int[] rej=new int[1];
            rej[0]=-1;
            return rej;
        }
        
        return ret;
    }
}


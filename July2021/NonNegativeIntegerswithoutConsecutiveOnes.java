// This is C++ Solution

// Please feel free to add java solution
class Solution {
  public:
  int findIntegers(int n) {
    int f[31];
    f[0] = 1;
    f[1] = 2;
    for (int i = 2; i < 31; ++i)
      f[i] = f[i-1]+f[i-2];

    int ans = 0, k = 30, pre_bit = 0;
    while (k >= 0) {
      if (n&(1<<k)) {
        ans += f[k];
        if (pre_bit) return ans;
        pre_bit = 1;
      }else {
        pre_bit = 0;
      }
      --k;
    }
    return ans+1;
  }
};



// This is Java Solution
class Solution {
    public int findIntegers(int n) {
        int[] f = new int[31];
        int res = 0;
        
        f[0] = 1;
        f[1] = 2;
        for(int i = 2; i < 31; i++){
            f[i] = f[i-1] + f[i-2];
        }
        
        String binaryStr = getBinary(n);
        
        for(int i = 0; i < binaryStr.length(); i++){
            if(binaryStr.charAt(i) == '0')
                continue;
            
            res += f[binaryStr.length() - i - 1];
            if(i != 0 && binaryStr.charAt(i-1) == '1')
                return res;
        }
        
        return res+1;
    }
    
    public String getBinary(int num){
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
            sb.insert(0, num&1);
            num >>= 1;
        }
        
        return sb.toString();
    }
}

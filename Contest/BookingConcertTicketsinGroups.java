// https://leetcode.com/problems/booking-concert-tickets-in-groups/
// @author: anuj0503
class BookMyShow {
    long[] seat;
    long[] countSeat;
    int N, M, last;
    
    public BookMyShow(int n, int m) {
        N = n; M = m; last = 0;
        seat = new long[N];
        countSeat = new long[N];
        
        Arrays.fill(seat, M);
        
        countSeat[0] = M;
        
        for(int i = 1; i < N; i++){
            countSeat[i] = countSeat[i-1] + M;
        }
    }
    
    public int[] gather(int k, int maxRow) {
        if(k > M)
            return new int[0];
        
        for(int i = 0; i <= maxRow; i++){
            if(seat[i] >= k){
                int[] result = new int[2];
                result[0] = i;
                result[1] = (int)(M - seat[i]);
                
                seat[i] -= k;
                
                for(int j = i; j < N; j++){
                    countSeat[j] -= k;
                }
                
                return result;
            }
        }
        
        return new int[0];
    }
    
    public boolean scatter(int k, int maxRow) {
        if(countSeat[maxRow] < k)
            return false;
        
        int count = 0;
        for(int i = last; i < N; i++){
            if(k > 0){
                if(seat[i] > 0){
                    if(seat[i] <= k){
                        count += seat[i];
                        k -= seat[i];
                        seat[i] = 0;

                        countSeat[i] = 0;
                        last = i;
                    } else {
                        count += k;
                        seat[i]-=k;
                        countSeat[i] -= count;
                        k = 0;
                    }
                }
            } else {
                countSeat[i] -= count;
            }
        }
        
        return true;
    }
}

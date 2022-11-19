class Solution {
public:
    int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
           int total_area = (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1);
           int area_to_be_subtracted = 0;
        
      
          if(ax2<=bx1 || bx2<=ax1 || ay2<=by1 || by2<=ay1){
            
            return total_area;
        }
       
            int x1 = min(ax2,bx2);
            int x2 = max(bx1,ax1);
            int length = abs(x2-x1);
            int y1 = min(ay2, by2);
            int y2 = max(by1,ay1);
            int breadth = abs(y1-y2);
        
         area_to_be_subtracted = length*breadth;
        
        return total_area - area_to_be_subtracted;
        
    }
};
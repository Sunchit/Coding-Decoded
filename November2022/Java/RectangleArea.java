// @saorav21994

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        // find out the top-left corner and bottom-right corner

        int tlax = ax1;
        int tlay = ay2;
        int brax = ax2;
        int bray = ay1;

        int tlbx = bx1;
        int tlby = by2;
        int brbx = bx2;
        int brby = by1;

        // find co-ordinates of the intersecting rectangle

        int blx = Math.max(ax1, bx1);
        int bly = Math.max(ay1, by1);

        int trx = Math.min(ax2, bx2);
        // int try = Math.min(ay2, by2);

        int tlx = Math.max(tlax, tlbx);
        int tly = Math.min(tlay, tlby);

        int brx = Math.min(brax, brbx);
        int bry = Math.max(brbx, brby);

        int carea = 0;
        if (tly < bly || blx > brx)
            carea = 0;
        else
            carea = Math.abs(brx-blx)*Math.abs(tly-bly);

        int tarea = (Math.abs(brax-ax1)*Math.abs(ay2-ay1)) + (Math.abs(by2-by1)*Math.abs(bx2-bx1));

        return tarea-carea;

    }
}

class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int colsestx=Math.max(x1, Math.min(xCenter,x2 ));
        int colsesty=Math.max(y1,Math.min(yCenter, y2));

        int dx=xCenter- colsestx;
        int dy=yCenter-colsesty ;

return (dx * dx) + (dy * dy) <= (radius * radius);
        
    }
}
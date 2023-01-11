public class String3 {

    public static float getShortestPath(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir = path.charAt(i);
            // South
            if(dir=='S'){
                y--;
            }else if(dir=='N'){
                y++;
            }else if(dir=='W'){
                x--;
            }else if(dir=='E'){
                x++;
            }
        }

       int X2 = x*x;
       int Y2 = y*y;
       return (float)Math.sqrt(X2+Y2);

    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getShortestPath(path));
        
    }
}

public class Interface1 {
   public static void main(String[] args) {
    
    Queen q = new Queen();
    q.moves();
    Rook r = new Rook();
    r.moves();

   } 
}

interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{

   public void moves(){
        System.out.println("up down left right diagonal(in all the 4 direction)");
    }

}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up down left right");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up down left right and diagonal by one step");
    }
}


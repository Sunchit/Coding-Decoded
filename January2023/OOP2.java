class Pen{
    // properties and functions
  private  String color;
   private int tip;

    String getColor(){
        return this.color;
    }

    int getTip(){
        return this.tip;
    }
void setColor(String newcolor){
    this.color = newcolor;
}
void setTip(int newtip){
    this.tip = newtip;
}

}

public class OOP2 {
    
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
       
        System.out.println(p1.getTip());
    }

}

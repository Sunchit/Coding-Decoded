public class Polymorphism2 {
    public static void main(String[] args) {
        Deer deer = new Deer();
        deer.eat();
        

    }
}
class Animal3{
    void eat(){
        System.out.println("Eats Anything.....");
    }

}

class Deer extends Animal3{
    void eat(){
        System.out.println("Eats only Grass.....");
    }
}
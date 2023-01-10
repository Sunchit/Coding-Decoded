public class Abstraction {
    public static void main(String[] args) {

        Horse10 horse = new Horse10();
        horse.walk();
        horse.eat();
       horse.changeColor();
        Chicken20 chicken = new Chicken20();
        chicken.walk();
        chicken.eat();
        
    }
}
abstract class Animal12{
    String color;
    void eat(){
        System.out.println("Animal Eats");
    }

    Animal12(){
        System.out.println("Animal Constructor called");
    }
    abstract void walk();

}

class Horse10 extends Animal12{

    void changeColor(){
        color = "White";
    }

    void walk(){
        System.out.println("Walk on 4 legs....");
    }
}
class Chicken20 extends Animal12{
    void walk(){
        System.out.println("Walks on 2 legs....");
    }
}
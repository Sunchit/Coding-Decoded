public class Inheritance3 {
    public static void main(String[] args) {
        Fish9 fish = new Fish9();
        fish.swim();
        fish.eat();
        fish.breathe();
        Mammal human = new Mammal();
        human.eat();
        human.breathe();
        human.walk();
    
        
    }
}
class Animal2{
    void eat(){
        System.out.println("Eating.........");
    }
    void breathe(){
        System.out.println("Breathing...");
    }
}

class Mammal extends Animal2{

    void walk(){
        System.out.println("Walking....");
    }

}

class Fish9 extends Animal2{
    void swim(){
        System.out.println("Swimming.......");
    }
}

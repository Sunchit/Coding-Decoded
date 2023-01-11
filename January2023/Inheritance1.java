public class Inheritance1 {
    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.eat();
        shark.breathe();
        shark.swim();
    }
}
// Base Class
class Animal{
    String color;

    void eat(){
        System.out.println("Eating....");
    }

    void breathe(){
        System.out.println("breathing....");
    }

}
class Fish extends Animal{
    int fins;
    void swim(){
        System.out.println("Swims in water....");
    }
}


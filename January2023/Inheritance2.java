public class Inheritance2 {

    // Multilevel Inheritance
    public static void main(String[] args) {
        Humans ankit = new Humans();
        ankit.color = "White";
        ankit.legs = 2;
        ankit.hands = 2;
        System.out.println(ankit.color);
        System.out.println(ankit.hands);
        System.out.println(ankit.legs);
        ankit.eat();
        ankit.swim();
        
    }
}

class Animals{
    String color;
    void eat(){
        System.out.println("Eating the food....");
    }
    void swim(){
        System.out.println("Swim with body....");
    }
}

class Mammals extends Animals{
     int legs;
}

class Humans extends Mammals{
    int hands;
}
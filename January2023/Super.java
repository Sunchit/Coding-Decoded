public class Super {
    public static void main(String[] args) {
        Horse7 h = new Horse7();
        h.eat();
    }
}

class Animal6{
    Animal6(){
        System.out.println("Animal Constructor is called...");

    }

}

class Horse7 extends Animal6{
Horse7(){
    super();
    System.out.println("Horse Constructor is called...");
}
 void eat(){
    System.out.println("Eating....");
 }

}
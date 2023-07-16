package CreationalDesignPattern.AbstractFactoryDesignPattern;

public class Test {
    public static void main(String[] args) {

        WagonRCarFactory wagonRCarFactory = new WagonRCarFactory();
        Car car = wagonRCarFactory.getCar();
        System.out.println("Car " + car.getClass().getName() + " has " + car.getEngineCC() + " with price " + car.getPrice());

    }
}

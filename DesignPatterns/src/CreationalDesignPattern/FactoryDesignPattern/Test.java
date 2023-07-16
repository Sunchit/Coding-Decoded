package CreationalDesignPattern.FactoryDesignPattern;

public class Test {
    public static void main(String[] args) {
        CarType testCar = CarType.SEDAN;
        MarutiCarFactory marutiCarFactory = new MarutiCarFactory();
        Car car = marutiCarFactory.getCar(testCar);
        System.out.println("Car " + car.getClass().getName() + " has " + car.getEngineCC() + " with price " + car.getPrice());

    }
}

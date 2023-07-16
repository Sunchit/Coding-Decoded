package CreationalDesignPattern.BuilderDesignPattern;

public class Test {
    public static void main(String[] args) {
        // method chaining
        Car.CarBuilder carBuilder = new Car.CarBuilder(2000, 2000000);
        carBuilder.setModelYear(2023);
        Car car = carBuilder.build();

    }
}

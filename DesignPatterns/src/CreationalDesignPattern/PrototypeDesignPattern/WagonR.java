package CreationalDesignPattern.PrototypeDesignPattern;

public class WagonR extends Car {

    public WagonR(Car car) {

        super(car);
        System.out.println("Creating new wadonR instance using copy constructor");
    }

    public WagonR() {
        super();
        System.out.println("Creating new WangonR instance using default constructor");
    }

    @Override
    public int getEngineCC() {
        return  1200;
    }

    @Override
    public int getPrice() {
        return 500000;
    }

    @Override
    public Car getClone(Car car) {
        return new WagonR(car);
    }
}

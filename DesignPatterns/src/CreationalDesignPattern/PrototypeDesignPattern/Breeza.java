package CreationalDesignPattern.PrototypeDesignPattern;

public class Breeza extends Car {

    public Breeza() {
        super();
        System.out.println("Creating new Breeza instance using default constructor");
    }

    public Breeza(Car car) {
        super(car);
        System.out.println("Creating new Breeza instance using copy constructor");
    }

    @Override
    public int getEngineCC() {
        return 1500;
    }

    @Override
    public int getPrice() {
        return 900000;
    }


    //@Override
    public Car getClone(Car car) {
        return new Breeza(car);
    }
}

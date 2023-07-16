package CreationalDesignPattern.AbstractFactoryDesignPattern;

public class WagonRCarFactory extends MarutiCarFactory {

    public Car getCar() {
        return new WagonR();
    }

}

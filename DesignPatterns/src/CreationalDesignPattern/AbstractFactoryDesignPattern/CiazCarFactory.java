package CreationalDesignPattern.AbstractFactoryDesignPattern;


public class CiazCarFactory extends MarutiCarFactory {
    @Override
    public Car getCar() {
        return new Ciaz();
    }
}

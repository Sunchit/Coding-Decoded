package CreationalDesignPattern.AbstractFactoryDesignPattern;

public class Breeza extends Car {
    @Override
    public int getEngineCC() {
        return 1500;
    }

    @Override
    public int getPrice() {
        return 900000;
    }
}

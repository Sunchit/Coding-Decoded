package CreationalDesignPattern.FactoryDesignPattern;

public class WagonR extends Car{
    @Override
    public int getEngineCC() {
        return  1200;
    }

    @Override
    public int getPrice() {
        return 500000;
    }
}

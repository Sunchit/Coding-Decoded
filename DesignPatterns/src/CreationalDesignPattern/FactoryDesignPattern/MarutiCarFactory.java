package CreationalDesignPattern.FactoryDesignPattern;

public class MarutiCarFactory {

    public MarutiCarFactory() {
    }

    public Car getCar(CarType carType) {
        switch (carType) {

            case SEDAN:
                return new Ciaz();

            case SUV:
                return new Breeza();

            case HATCHBACK:
                return new WagonR();


        }
        return null;
    }
}

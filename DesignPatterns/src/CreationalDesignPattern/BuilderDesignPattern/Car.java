package CreationalDesignPattern.BuilderDesignPattern;

public class Car {

    private final int modelYear;
    private final int engineCC;

    private final int price;

    public int getModelYear() {
        return modelYear;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public int getPrice() {
        return price;
    }

    private Car(CarBuilder carBuilder) {
        this.modelYear = carBuilder.modelYear;
        this.engineCC = carBuilder.engineCC;
        this.price = carBuilder.price;
    }


    //Builder Class
    public static class CarBuilder{
        private final int engineCC;
        private final int price;

        public int getModelYear() {
            return modelYear;
        }

        public void setModelYear(int modelYear) {
            this.modelYear = modelYear;
        }

        private int modelYear;

        public CarBuilder(int engineCC, int price) {
            this.engineCC = engineCC;
            this.price = price;
        }
        public Car build(){
            return new Car(this);
        }

    }

}
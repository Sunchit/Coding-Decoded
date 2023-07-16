package CreationalDesignPattern.PrototypeDesignPattern;

public abstract class Car implements VehicleInterface, Clone {
    private int modelYear;

    public Car() {
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public Car(Car car) {
        this.modelYear = car.modelYear;
    }
}

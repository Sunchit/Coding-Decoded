package CreationalDesignPattern.PrototypeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
        Breeza breeza = new Breeza();
        breeza.setModelYear(2023);

        WagonR wagonR = new WagonR();
        wagonR.setModelYear(2019);

        carList.add(breeza);
        carList.add(wagonR);

        for(Car car : carList) {
            System.out.println(car.getClass().getName() +" " + car.toString()+ " " +car.getModelYear());
        }

        List<Car> copyCarList = new ArrayList<>();


        for(Car car : carList) {
            if(car instanceof Breeza){
                int  modelYear = ((Breeza)car).getModelYear();
                Breeza  copyBreeze = new Breeza();
                copyBreeze.setModelYear(modelYear);
                copyCarList.add(copyBreeze);
            } else if (car instanceof WagonR){
                int  modelYear = ((WagonR)car).getModelYear();
                WagonR  copyWagonR = new WagonR();
                copyWagonR.setModelYear(modelYear);
                copyCarList.add(copyWagonR);
            }

        }


//        for(Car car : carList) {
//            copyCarList.add(car.getClone(car));
//        }


        for(Car car : copyCarList) {
            System.out.println(car.getClass().getName() +" " + car.toString()+ " " +car.getModelYear());
        }
    }
}

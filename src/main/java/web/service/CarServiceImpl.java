package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars() {
        List<Car> carList = new ArrayList<>();
        int i = 1;
        while (i <= 5) {
            carList.add(new Car("Car" + i, "Model" + i));
            i++;
        }
        return carList;
    }
}

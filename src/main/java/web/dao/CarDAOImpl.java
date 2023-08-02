package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAOImpl implements CarDAO {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        Car Toyota = new Car("Toyota", 111, 25000);
        Car Lada = new Car("Лада", 222, 45000);
        Car Volvo = new Car("Volvo", 333, 11000);
        Car Nissan = new Car("Nissan", 444, 74000);
        Car Volga = new Car("Волга", 555, 112000);

        cars.add(Toyota);
        cars.add(Lada);
        cars.add(Volvo);
        cars.add(Nissan);
        cars.add(Volga);
    }
    @Override
    public List<Car> getCarsList(int count) {
        ArrayList<Car> carList = new ArrayList<>();
        for (int i=0; i<count; i++) {
            carList.add(cars.get(i));
        }
        return carList;
    }


}

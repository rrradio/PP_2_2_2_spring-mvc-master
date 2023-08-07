package web.service;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

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
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        ArrayList<Car> carList = new ArrayList<>();
        if (count > 5) {
            count = 5;
        }
        for (int i=0; i<count; i++) {
            carList.add(cars.get(i));
        }

        model.addAttribute("cars", carList);
        return "cars";
    }
}

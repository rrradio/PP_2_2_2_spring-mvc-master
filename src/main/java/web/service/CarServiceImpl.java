package web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAOImpl;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarDAOImpl carDAOImpl;

    public CarServiceImpl(CarDAOImpl carDAOImpl) {
        this.carDAOImpl = carDAOImpl;
    }

    @Override
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        List<Car> cars;
        if (count > 5) {
            count = 5;
        }
        cars = carDAOImpl.getCarsList(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}

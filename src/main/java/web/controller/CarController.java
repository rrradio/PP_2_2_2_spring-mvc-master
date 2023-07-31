package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;
import web.model.Car;
import java.util.List;

@Controller
public class CarController {

    private final CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/cars")
    public String numberOfCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        List<Car> cars;
        cars = carDAO.getCars(count);
        model.addAttribute("cars", cars);
        return "cars";
    }



}

package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model, @RequestParam(name = "count", required = false, defaultValue = "0") int count) {
        CarService carService = new CarServiceImpl();
        List<Car> carList = carService.getCars();

        if (count > 0 && count < carList.size()) {
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                cars.add(carList.get(i));
            }
            model.addAttribute("messages", cars);
        } else {
            model.addAttribute("messages", carList);
        }
        return "cars";
    }
}

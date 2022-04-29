package dev.fitzgerald.controllers;


import dev.fitzgerald.entities.Car;
import dev.fitzgerald.services.CarService;
import dev.fitzgerald.services.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@Controller
public class CarController {

    @Autowired
    private CarService carservice = new CarServiceImpl();


    @GetMapping("/cars")
    @ResponseBody
    public List<Car> getAllCars(){
        List<Car> cars = this.carservice.getAllCars();
        return cars;
    }


    @GetMapping("/cars/{id}")
    @ResponseBody
    public Car getCarById(@PathVariable Integer id) {
        return this.carservice.getCarById(id);
    }


    @PostMapping("/cars")
    @ResponseBody
    public Car createCar(@RequestBody Car car) {
        return this.carservice.registerCar(car);
    }

    @PatchMapping("/cars/{id}")
    @ResponseBody
    public Car updateCar(@PathVariable Integer id, @RequestBody Car car){
        car.setId(id);
        return this.carservice.updateCar(car);
    }

    @GetMapping("/cars/mileage/{miles}")
    @ResponseBody
    public List<Car> getCarsByMake(@PathVariable Integer miles){
        return this.carservice.getCarsUnderMileage(miles);
    }

    @RequestMapping(path = "/cars/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void deleteCar(@PathVariable Integer id){
        this.carservice.deleteCar(id);
    }
}
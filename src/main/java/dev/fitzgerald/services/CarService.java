package dev.fitzgerald.services;

import dev.fitzgerald.entities.Car;

import java.util.List;

public interface CarService {

    Car registerCar(Car car);

    List<Car> getAllCars();
    Car getCarById(Integer id);
    List<Car> getCarsUnderMileage(Integer mileage);
    Car updateCar(Car car);
    boolean deleteCar(int id);

}

package dev.fitzgerald.services;

import dev.fitzgerald.entities.Car;
import dev.fitzgerald.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Override
    public Car registerCar(Car car) {
        return this.carRepo.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return this.carRepo.findAll();
    }

    @Override
    public Car getCarById(Integer id) {
        Optional<Car> possibleCar = this.carRepo.findById(id);
        if(possibleCar.isPresent()){
            return possibleCar.get();
        } else {
            throw new RuntimeException("No Such car with ID " + id);
        }
    }

    @Override
    public List<Car> getCarsUnderMileage(Integer mileage) {
        List<Car> allCars = this.getAllCars();
        List<Car> processedCars = new ArrayList<>();
        for(int i = 0; i < allCars.size(); i++){
            if(allCars.get(i).getMileage() < mileage) {
                processedCars.add(allCars.get(i));
            }
        }
        return processedCars;
    }

    @Override
    public Car updateCar(Car car) {
        this.carRepo.save(car);
        return car;
    }

    @Override
    public boolean deleteCar(int id) {

        this.carRepo.delete(this.carRepo.getById(id));
        return true;
    }
}
